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
 *    Created on  30.08.2012
 *
 ************************************************************************/
package de.dsa.composite;

public class TestMain {

    public static void main(String[] args) {
        try {
            System.out.println("Makint root entries....");
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            rootDir.printList();

            System.out.println("");
            System.out.println("Making user entries....");
            Directory jz = new Directory("jz");
            Directory da = new Directory("da");
            Directory rt = new Directory("rt");
            usrDir.add(jz);
            usrDir.add(da);
            usrDir.add(rt);
            jz.add(new File("diary.html", 100));
            jz.add(new File("Composite.java", 200));
            da.add(new File("memo.tex", 300));
            rt.add(new File("game.doc", 400));
            rt.add(new File("junk.mail", 500));
            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

    }
}
