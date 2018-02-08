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

public class Main {

    /**
     * COMMENT - Enter concise description of the method's purpose.
     *           Description should go beyond the method name.
     *           Use the following format:
     *
     * <Short description (short verb phrase possible) followed by a dot>
     * <More elaborate description of "what" this method does. Omit the "how" unless necessary.>
     *
     * @param args
     */
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();

    }

}
