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

public class RadioCommandTest {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Command fmCommand = new FMCommand(radio);
        Command amCommand = new AMCommand(radio);
        KeyPad keyPad = new KeyPad();
        keyPad.setFMcommand(fmCommand);
        keyPad.setAMcommand(amCommand);

        MacroCommand mCommand = new MacroRadioCommand();
        keyPad.setMacroCommand(mCommand);
        keyPad.am();
        keyPad.fm();
        keyPad.am();
        keyPad.fm();
        keyPad.am();
        System.out.println("---------------------------");
        keyPad.macro();
    }
}
