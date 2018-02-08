/************************************************************************
 *                                                                      *
 *  DDDD     SSSS    AAA        Daten- und Systemtechnik Aachen GmbH    *
 *  D   D   SS      A   A       Pascalstrasse 28                        *
 *  D   D    SSS    AAAAA       52076 Aachen-Oberforstbach, Germany     *
 *  D   D      SS   A   A       Telefon: +49 (0)2408 / 9492-0           *
 *  DDDD    SSSS    A   A       Telefax: +49 (0)2408 / 9492-92          *
 *                                                                      *
 *                                                                      *
 *  (c) Copyright by DSA - all rights reserved                          *
 *                                                                      *
 ************************************************************************
 *
 * Initial Creation:
 *    Author      jz
 *    Created on  06.01.2012
 *
 ************************************************************************/
package de.dsa.packagegen;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PackageGenerator {

    private static final String filePrefix = "C:/MANcatsIII_";
    private static String dataFile;
    private static final String cerFile = "C:/packageGen.cer";
    private static String sigFile;
    private static String zipFile;

    static public void generatePcidData(DefaultTableModel tabModel,
            String pcid, String createDate) {
        int pkgCount = tabModel.getDataVector().size();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(
                    18 + pkgCount * 3);
            DataOutputStream dout = new DataOutputStream(bout);
            dout.writeByte(0x01);
            dout.write(pcid.getBytes("ASCII"));
            dout.writeByte(0xff);
            Date date = (Date) new SimpleDateFormat("yyyy.MM.dd")
                    .parse(createDate);
            dout.writeLong(date.getTime());
            dout.writeByte(pkgCount);
            int nr;
            int nr2;
            for (int i = 0; i < pkgCount; i++) {
                Vector vec = (Vector) tabModel.getDataVector().get(i);
                nr = Integer.parseInt((String) vec.get(1)); // runtime right package id
                dout.writeByte(nr);
                nr = Integer.parseInt((String) vec.get(3)); // hour
                nr <<= 11;
                nr2 = Integer.parseInt((String) vec.get(2)); // day
                nr2 = nr | nr2;
                dout.writeShort(nr2);
            }
            dataFile = filePrefix + "_" + pcid + "_" + createDate + ".dat";
            FileOutputStream fos = new FileOutputStream(dataFile);
            bout.writeTo(fos);
            fos.flush();
            fos.close();
            bout.close();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Date Format Error: yyyy.MM.dd", "Date format error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private static final String KEYSTORE = "packageGen.keystore";
    private static final String PASSWORD = "121212";
    private static final String ALIAS = "pkggen";

    static public void generateSign(String pcid, String createDate) {
        InputStream is = PackageGenerator.class.getResourceAsStream(KEYSTORE); //$NON-NLS-1$
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(is, PASSWORD.toCharArray());
            Key key = keyStore.getKey(ALIAS, PASSWORD.toCharArray());
            PrivateKey priKey = (PrivateKey) key;

            Signature signRSA = Signature.getInstance("SHA1withRSA");
            signRSA.initSign(priKey);
            is.close();

            is = new FileInputStream(dataFile);
            // is = PackageGenerator.class.getResourceAsStream(dataFile);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) >= 0) {
                signRSA.update(buffer, 0, len);
            }
            bis.close();

            sigFile = filePrefix + "_" + pcid + "_" + createDate + ".sig";
            byte[] realSig = signRSA.sign();
            File signFile = new File(sigFile);
            FileOutputStream sigfos = new FileOutputStream(signFile);
            sigfos.write(realSig);
            sigfos.close();
            is.close();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }

    static public void generateZip(String pcid, String createDate) {
        String[] filenames = new String[] { sigFile, dataFile, cerFile };
        byte[] buf = new byte[1024];

        try {
            zipFile = filePrefix + "_" + pcid + "_" + createDate + ".zip";
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    zipFile));

            // Compress the files
            for (int i = 0; i < filenames.length; i++) {
                FileInputStream in = new FileInputStream(filenames[i]);
                File file = new File(filenames[i]);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
