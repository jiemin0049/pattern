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
 *    Created on  31.08.2011
 *
 ************************************************************************/
package de.dsa.adapter.delegate;

public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String text) {
        banner = new Banner(text);
    }

    public void printWeak() {
        banner.showWithParen();

    }

    public void printStrong() {
        banner.showWithAster();

    }

}
