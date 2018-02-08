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
package de.dsa.listener.mouselistener;

public class Model {
    private MouseListener[] listeners = new MouseListener[50];

    int index = 0;

    public void addListener(MouseListener listener) {

        listeners[index++] = listener;
    }

    public void clickModel() {

        for (int i = 0; i < index; i++) {
            listeners[i].click();
        }
    }

    public static void main(String[] args) {
        Model model = new Model();

        model.addListener(new MouseListener() {

            public void click() {
                System.out.println("clicked 1");
            }
        });

        model.addListener(new MouseListener() {
            public void click() {
                System.out.println("clicked 2");
            }
        });

        model.clickModel();
    }
}
