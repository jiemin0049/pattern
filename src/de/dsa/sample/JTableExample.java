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
 *    Created on  12.09.2012
 *
 ************************************************************************/

package de.dsa.sample;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class JTableExample {

    private String[] _titles = new String[] { "Name", "Vage" };
    private String[][] _data = new String[][] { { "Donald Duck", "100" }, { "Mickey Mouse", "120" } };

    public JTableExample() {
        // Make the frame
        JFrame frame = new JFrame("JFrame and JTable example 2");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Action when window closes

        JTable table = new JTable(_data, _titles); // Make table

        InputMap im = table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).getParent();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), null);
        JScrollPane scrollPane = new JScrollPane(table); // Make scrollpane with table

        // Add scrollpane with table to the frame and show the frame to user
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(new JButton("ok"), BorderLayout.EAST);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        JTableExample frame = new JTableExample();
    }
}
