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

public class TestMain {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.register("box", new MessageBox('*'));
        manager.register("warning_box", new MessageBox('!'));
        manager.register("pen", new UnderlinePen('-'));

        Product p1 = manager.create("box");
        p1.use("hello");
        Product p2 = manager.create("pen");
        p2.use("what's up?");
        Product p3 = manager.create("warning_box");
        p3.use("alarm");
    }
}
