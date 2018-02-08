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
 *    Created on  30.08.2012
 *
 ************************************************************************/
package de.dsa.composite;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {

    private String name;
    private Vector<Entry> dirs = new Vector<Entry>();

    public Directory(String pName) {
        name = pName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = dirs.iterator();
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size;
    }

    public Entry add(Entry entry) {
        dirs.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator<Entry> it = dirs.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.printList(prefix + "/" + name);
        }
    }

}
