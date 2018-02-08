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
 *    Created on  07.09.2011
 *
 ************************************************************************/
package de.dsa.command.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack<Command>();
    private Stack<Command> redoCommands = new Stack<Command>();

    public void execute() {
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }

    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    public void undo() {
        if (!commands.empty()) {
            appendRedo(commands.pop());
        }
    }

    public void redo() {
        if (!redoCommands.empty()) {
            append(redoCommands.pop());
        }
    }

    private void appendRedo(Command cmd) {
        if (cmd != this) {
            redoCommands.push(cmd);
        }
    }

    public void clear() {
        commands.clear();
        redoCommands.clear();
    }

}
