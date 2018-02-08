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
 *    Created on  30.08.2011
 *
 ************************************************************************/
package de.dsa.memento;

public class PlayGame {

    /**
     * COMMENT - Enter concise description of the method's purpose.
     *           Description should go beyond the method name.
     *           Use the following format:
     *
     * <Short description (short verb phrase possible) followed by a dot>
     * <More elaborate description of "what" this method does. Omit the "how" unless necessary.>
     *
     * @param args
     */
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("status: " + gamer);
            gamer.bet();
            System.out.println("amount of money: " + gamer.getMoney() + "$");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("Earn more money, save");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("lose to many money, restore");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }

}
