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

public class TestMain {
    public static void main(String[] args) {
        Builder b = new StarBuilder("stars");
        Director d = new Director(b);
        String s = d.construct();
        System.out.println(s);

        b = new PlusBuilder("plus");
        d = new Director(b);
        s = d.construct();
        System.out.println(s);

    }
}
