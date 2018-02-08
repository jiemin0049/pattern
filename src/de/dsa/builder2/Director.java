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

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Object construct() {
        builder.makeTitle("Greeting");
        builder.makeString("from moring to day end");
        builder.makeItems(new String[] { "moring", "afternoon", });
        builder.makeString("to night");
        builder.makeItems(new String[] { "good night", "wish a good dream", "bye", });
        return builder.getResult();
    }
}
