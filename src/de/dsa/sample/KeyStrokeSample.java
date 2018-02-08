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

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class KeyStrokeSample {
    private static final String ACTION_KEY = "theAction";

    public static void main(String args[]) {
        JFrame frame = new JFrame("KeyStroke Sample");

        JButton buttonA = new JButton("<html><center>FOCUSED<br>control alt 7");
        JButton buttonB = new JButton("<html><center>FOCUS/RELEASE<br>VK_ENTER");
        JButton buttonC = new JButton("<html><center>ANCESTOR<br>VK_F4+SHIFT_MASK");
        JButton buttonD = new JButton("<html><center>WINDOW<br>' '");

        // Define ActionListener
        Action actionListener = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                JButton source = (JButton)actionEvent.getSource();
                System.out.println("Activated: " + source.getText());
            }
        };

        KeyStroke controlAlt7 = KeyStroke.getKeyStroke("control alt 7");
        InputMap inputMap = buttonA.getInputMap();
        inputMap.put(controlAlt7, ACTION_KEY);
        ActionMap actionMap = buttonA.getActionMap();
        actionMap.put(ACTION_KEY, actionListener);

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true);
        inputMap = buttonB.getInputMap();
        inputMap.put(enter, ACTION_KEY);
        buttonB.setActionMap(actionMap);

        KeyStroke shiftF4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.SHIFT_MASK);
        inputMap = buttonC.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(shiftF4, ACTION_KEY);
        buttonC.setActionMap(actionMap);

        KeyStroke space = KeyStroke.getKeyStroke(' ');
        inputMap = buttonD.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(space, ACTION_KEY);
        buttonD.setActionMap(actionMap);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 2));
        contentPane.add(buttonA);
        contentPane.add(buttonB);
        contentPane.add(buttonC);
        contentPane.add(buttonD);

        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}