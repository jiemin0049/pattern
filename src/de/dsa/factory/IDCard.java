package de.dsa.factory;
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

public class IDCard extends Product {

    private String owner;

    public IDCard(String pOwner) {
        owner = pOwner;
        System.out.println("create ID card for: " + pOwner);
    }

    @Override
    public void use() {
        System.out.println("use ID card: " + owner);
    }

    public String getOwner() {
        return owner;
    }

}
