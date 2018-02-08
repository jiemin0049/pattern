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
 *    Created on  16.09.2011
 *
 ************************************************************************/
package de.dsa.command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import de.dsa.command.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {

    private Color color = Color.RED;

    private int radius = 6;

    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
    }

    public void paint(Graphics g) {
        history.execute();
    }

    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius *2, radius * 2);
    }

}
