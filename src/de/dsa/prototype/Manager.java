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
 *    Created on  01.08.2012
 *
 ************************************************************************/
package de.dsa.prototype;

import java.util.Hashtable;

public class Manager {
    private Hashtable<String, Product> showCaseTable = new Hashtable<String, Product>();

    public void register(String name, Product p) {
        showCaseTable.put(name, p);
    }

    public Product create(String name) {
        Product p = showCaseTable.get(name);
        return p.createClone();
    }

}
