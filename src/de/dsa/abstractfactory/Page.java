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
 *    Created on  25.07.2012
 *
 ************************************************************************/
package de.dsa.abstractfactory;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Vector;

public abstract class Page {
    protected String title;
    protected String author;
    protected Vector<Item> content = new Vector<Item>();

    public Page(String t, String a) {
        title = t;
        author = a;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        try {
            String fileName = title + ".html";
            Writer writer = new FileWriter(fileName);
            writer.write(makeHTML());
            writer.close();
            System.out.println("Generate " + fileName + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();
}
