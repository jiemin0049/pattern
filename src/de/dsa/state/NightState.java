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

public class NightState implements State {
    private static NightState singleton = new NightState();

    private NightState() {
    }

    public static State getInstance() {
        return singleton;
    }

    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.callSecurityCenter("Exception: Using coffers(night)!");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("Alarm bell(night)");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("Call Recording(night)");
    }

    public String toString() {
        return ("night");
    }

}
