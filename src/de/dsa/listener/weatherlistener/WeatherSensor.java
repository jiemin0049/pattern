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
package de.dsa.listener.weatherlistener;

import java.util.ArrayList;
import java.util.List;


public class WeatherSensor {

    private List<WeatherListener> listeners = new ArrayList<WeatherListener>();

    private String weatherType;

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String type) {
        if (weatherType == null) {
            weatherType = "";
        }
        if (!weatherType.equals(type)) {
            weatherType = type;
            WeatherEvent event = new WeatherEvent(this, weatherType);
            fireEvent(event);
        }
    }


    public void fireEvent(WeatherEvent evt) {
        for (int i = 0; i < listeners.size(); i++) {
            WeatherListener listener = listeners.get(i);
            listener.performed(evt);
        }
    }

    public synchronized void addListener(WeatherListener l) {
        listeners.add(l);
    }

    public synchronized void removeListener(WeatherListener l) {
        listeners.remove(l);
    }
}
