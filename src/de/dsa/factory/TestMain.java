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
 *    Created on  19.07.2012
 *
 ************************************************************************/
package de.dsa.factory;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        Factory f = new IDCardFactory();
        Product p1 = f.create("jz");
        p1.use();
        Product p2 = f.create("man");
        p2.use();
        Product p3 = f.create("vw");
        p3.use();
        Product p4 = f.create("bmw");
        p4.use();

        List<String> owners = ((IDCardFactory)f).getOwners();
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(owners.get(i));
        }
    }
}
