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

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class Gamer {

    private int money;
    private Vector<String> fruits = new Vector<String>();
    private Random random = new Random();
    private static String[] fruitsname = { "apple", "banana", "orange", "grape" };

    public Gamer(int pMoney) {
        money = pMoney;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("more money");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("money half");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("get fruit: " + f);
            fruits.add(f);
        } else {
            System.out.println("nothing happens");
        }
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "delicious ";
        }

        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }

    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            String f = it.next();
            if (f.startsWith("delicious")) {
                m.addFruits(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {
        money = memento.money;
        fruits = memento.getFruits();
    }

    public String toString(){
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
}
