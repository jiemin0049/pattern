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

public class KeyPad {
    Command fmCommand;
    Command amCommand;
    MacroCommand macroCommand;

    public void setFMcommand(Command fm) {
        fmCommand = fm;
    }

    public void setAMcommand(Command am) {
        amCommand = am;
    }

    public void setMacroCommand(MacroCommand mCommand) {
        macroCommand = mCommand;
    }

    public void am() {
        amCommand.switchBand();
        if (macroCommand != null) {
            macroCommand.add(amCommand);
        }
    }

    public void fm() {
        fmCommand.switchBand();
        if (macroCommand != null) {
            macroCommand.add(fmCommand);
        }
    }

    public void macro() {
        macroCommand.switchBand();
    }

}
