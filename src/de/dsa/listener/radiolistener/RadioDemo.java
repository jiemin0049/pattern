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
 *    Created on  24.08.2011
 *
 ************************************************************************/
package de.dsa.listener.radiolistener;


public class RadioDemo {
    public static void main(String args[]) {
        Radio r = new Radio();

        class ComplainingAdListener implements AdListener {
            public void advertisement(AdEvent e) {
                System.out.println("Oh nein, schon wieder Werbung: " + e.getSlogan());
            }
        }

        class ComplainingAdListener2 implements AdListener {
            public void advertisement(AdEvent e) {
                System.out.println("I love Werbung: " + e.getSlogan());
            }
        }

        r.addAdListener(new ComplainingAdListener());
        r.addAdListener(new ComplainingAdListener2());
    }

}