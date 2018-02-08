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
 *    Created on  17.09.2014
 *
 ************************************************************************/
package de.dsa.command.radio;

import java.util.ArrayList;
import java.util.List;

public class MacroRadioCommand implements MacroCommand {

    private List<Command> commandList = new ArrayList<Command>();

    public void switchBand() {
        for (Command cmd : commandList) {
            cmd.switchBand();
        }
    }

    public void add(Command command) {
        commandList.add(command);
    }

    public void remove(Command command) {
        commandList.remove(command);
    }

}
