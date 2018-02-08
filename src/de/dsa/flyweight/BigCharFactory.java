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

import java.util.Hashtable;

public class BigCharFactory {
    private Hashtable<String, BigChar> pool = new Hashtable<String, BigChar>();
    private static BigCharFactory singleton = new BigCharFactory();

    public BigCharFactory() {

    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char ch) {
        BigChar bc = (BigChar)pool.get("" + ch);
        if (bc == null) {
            bc = new BigChar(ch);
            pool.put("" + ch, bc);
        }
        return bc;
    }
}
