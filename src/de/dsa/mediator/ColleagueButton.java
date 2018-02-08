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
 *    Created on  06.11.2012
 *
 ************************************************************************/
package de.dsa.mediator;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    /**
     * COMMENT - Add concise description of the purpose of this field.
     *           Description should go beyond the field's name.
     *
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8789074722816726938L;

    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
