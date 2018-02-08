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
 *    Created on  19.09.2011
 *
 ************************************************************************/
package de.dsa.builder2;

public class TextBuilder extends Builder {

    private StringBuffer buffer = new StringBuffer();

    public void makeTitle(String title) {
        buffer.append("================================\n");
        buffer.append("§ " + title + "§ \n");
        buffer.append("\n");
    }

    public void makeString(String str) {
        buffer.append('@' + str + "\n");
        buffer.append("\n");
    }

    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("\n");
        }
    }

    public Object getResult() {
        buffer.append("================================\n");
        return buffer.toString();
    }

}
