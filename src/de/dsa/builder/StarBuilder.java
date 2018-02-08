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
 *    Created on  07.08.2012
 *
 ************************************************************************/
package de.dsa.builder;

public class StarBuilder extends Builder {
    private StringBuffer stringBuff = new StringBuffer();
    private String str;
    private int ll;

    public StarBuilder(String s) {
        str = s;
        ll = str.length() + 2;
    }

    @Override
    void buildTitle() {
        printStarLine();
    }

    @Override
    void buildContent() {
        stringBuff.append("*").append(str).append("*\n");
    }

    @Override
    void buildTail() {
        printStarLine();
    }

    private void printStarLine() {
        for (int i = 0; i < ll; i++) {
            stringBuff.append("*");
        }
        stringBuff.append("\n");
    }

    @Override
    String getResult() {
        return stringBuff.toString();
    }

}
