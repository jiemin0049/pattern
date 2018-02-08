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
 *    Created on  26.11.2012
 *
 ************************************************************************/
package de.dsa.flyweight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    private char charName;
    private String fontData;

    public BigChar(char ch) {
        charName = ch;

        try {
            File f = new java.io.File(".").getCanonicalFile();
            BufferedReader reader = new BufferedReader(new FileReader(f.getAbsoluteFile() + "\\big" + charName + ".txt"));
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            fontData = buf.toString();

        } catch (IOException e) {
            fontData = charName + "?";
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}