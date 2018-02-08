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
 *    Created on  24.08.2011
 *
 ************************************************************************/
package de.dsa.listener.radiolistener;

import java.util.*;
import javax.swing.event.EventListenerList;

public class Radio {
    /** List of listeners. */
    private EventListenerList listeners = new EventListenerList();

    /** All advertisements. */
    private List<String> ads = Arrays.asList("Jetzt explodiert auch der Haarknoten", "Red Fish verleiht Flossen", "Bom Chia Wowo", "Wunder Whip. Iss milder.");

    /** Radio with frequent ads. */
    public Radio() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Collections.shuffle(ads);
                notifyAdvertisement(new AdEvent(this, ads.get(0)));
            }
        }, 0, 5000);
    }

    /**
     * Adds an {@code AdListener} to the radio.
     * @param l the {@code AdListener} to be added
     */
    public void addAdListener(AdListener listener) {
        listeners.add(AdListener.class, listener);
    }

    /**
     * Removes an {@code AdListener} from the radio.
     * @param l the listener to be removed
     */

    public void removeAdListener(AdListener listener) {
        listeners.remove(AdListener.class, listener);
    }

    /**
     * Notifies all {@code AdListener}s that have registered interest for
     * notification on an {@code AdEvent}.
     * @param event  the {@code AdEvent} object
     * @see EventListenerList
     */
    protected synchronized void notifyAdvertisement(AdEvent event) {
        for (AdListener l : listeners.getListeners(AdListener.class))
            l.advertisement(event);
    }
}
