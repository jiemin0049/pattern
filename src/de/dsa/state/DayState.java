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
 *    Created on  23.11.2012
 *
 ************************************************************************/
package de.dsa.state;

public class DayState implements State {

    private static DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.recordLog("Using coffers(day)");

    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("Alarm bell(day)");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("normal call(day)");
    }

    public String toString() {
        return ("day");
    }

}
