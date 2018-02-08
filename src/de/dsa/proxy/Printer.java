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
 *    Created on  04.12.2012
 *
 ************************************************************************/
package de.dsa.proxy;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Printer object is creating");
    }

    Printer(String name) {
        this.name = name;
        heavyJob("Printer object (" + name + ") is creating");
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("finish.");
    }

    public void setPrinterName(String name) {
        this.name = name;

    }

    public String getPrinterName() {
        return name;
    }

    public void print(String string) {
        System.out.println("===" + name + "===");
        System.out.println(string);
    }

}
