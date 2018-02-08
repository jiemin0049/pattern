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

public class EventListenerTester implements EventListener {
    private boolean loop = true;

    public void execute() {
        Timer timer = new Timer(3);
        timer.setEventListener(this);
        timer.start();

        while (loop) {
            try {
                Thread.sleep(1000);
                System.out.println("still in while(true) loop");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println("interupted by time out event");
    }

    public void handleEvent(EventSource event) {
        int eType = event.getEventType();
        switch (eType) {
            case EventSource.EVENT_TIMEOUT:
                this.loop = false;
                break;
            case EventSource.EVENT_OVERFLOW:
                break;
            default:
                this.loop = true;
                break;
        }
    }

    public static void main(String[] args) {
        EventListenerTester tester = new EventListenerTester();
        tester.execute();
    }
}
