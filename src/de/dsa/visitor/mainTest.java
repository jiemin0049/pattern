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
 *    Created on  24.09.2012
 *
 ************************************************************************/
package de.dsa.visitor;

public class mainTest {
    public static void main(String[] args) {

        try {
            System.out.println("Making root entries....");
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tempDir = new Directory("temp");
            Directory usrDir = new Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tempDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            rootDir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries....");
            Directory jz = new Directory("Jiemin");
            Directory tim = new Directory("Tim");
            Directory oliver = new Directory("Oliver");
            usrDir.add(jz);
            usrDir.add(tim);
            usrDir.add(oliver);
            jz.add(new File("diary.html", 100));
            jz.add(new File("Composite.java", 200));
            tim.add(new File("memo.tex", 300));
            oliver.add(new File("game.doc", 400));
            oliver.add(new File("junk.mail", 500));
            rootDir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

    }
}
