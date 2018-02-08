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
 *    Created on  29.08.2011
 *
 ************************************************************************/
package de.dsa.memento;

import java.util.Vector;

public class Memento {
    int money;
    Vector<String> fruits;
    public int getMoney() {
        return money;
    }

    public Memento(int money) {
        this.money = money;
        this.fruits = new Vector<String>();
    }

    void addFruits(String fruit) {
        fruits.add(fruit);
    }

    Vector<String> getFruits() {
        return fruits;
    }

}
