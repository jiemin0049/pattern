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
 *    Created on  13.09.2012
 *
 ************************************************************************/
package de.dsa.sample;

import javax.swing.JFrame;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class AncestorSampler {
    public static void main(String args[]) {
        JFrame f = new JFrame("Ancestor Sampler");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AncestorListener ancestorListener = new AncestorListener() {
            public void ancestorAdded(AncestorEvent ancestorEvent) {
                System.out.println("Added");
            }

            public void ancestorMoved(AncestorEvent ancestorEvent) {
                System.out.println("Moved");
            }

            public void ancestorRemoved(AncestorEvent ancestorEvent) {
                System.out.println("Removed");
            }
        };
        f.getRootPane().addAncestorListener(ancestorListener);
        f.getRootPane().setVisible(false);
        f.getRootPane().setVisible(true);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}