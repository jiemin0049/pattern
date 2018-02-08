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
 *    Created on  29.08.2011
 *
 ************************************************************************/
package de.dsa.listener.timerlistener;

public class Timer extends Thread {
    private EventListener listener;
    private int sleepSeconds;

    public Timer(int seconds) {
        this.sleepSeconds = seconds;
    }

    public void setEventListener(EventListener listener) {
        this.listener = listener;
    }

    public void run() {
        for (int i = sleepSeconds; i > 0; i--) {
            try {
                System.err.println("in sleep");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }

        notifyTimeoutEvent();
    }

    private void notifyTimeoutEvent() {
        this.listener.handleEvent(new TimeOutEvent());
    }
}
