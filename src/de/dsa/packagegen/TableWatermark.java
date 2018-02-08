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
 *    Created on  26.08.2014
 *
 ************************************************************************/
package de.dsa.packagegen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableWatermark extends JScrollPane {
    BufferedImage bi;

    public TableWatermark(JTable tabel, URL url) {
        super(tabel);
        try {
            bi = ImageIO.read(url);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        setOpaque(false);
        getViewport().setOpaque(false);
        tabel.setOpaque(false);
        setViewportView(tabel);
    }

    protected void paintComponent(Graphics graph) {
        final int imgWidth = bi.getWidth();
        final int imgHeight = bi.getHeight();
        Dimension dim = getSize();
        int x = (dim.width - imgWidth) / 2;
        int y = (dim.height - imgHeight) / 2;
        graph.drawImage(bi, x, y, null, null);
        super.paintComponent(graph);
    }
}
