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
 *    Created on  20.06.2014
 *
 ************************************************************************/
package de.dsa.memento2;

public class Client {

    private static Originator o = new Originator();
    private static Caretaker c = new Caretaker();

    public static void main(String[] args) {
        o.setState("on");
        c.saveMemento(o.createMemento());
        o.setState("off");
        o.restoreMemento(c.retrieveMemento());
    }

}
