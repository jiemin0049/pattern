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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WeatherDemo {

    public static void main(String[] args) {
        final WeatherSensor sensor = new WeatherSensor();
        final AutomaticWindow win = new AutomaticWindow();
        final AutomaticDoor door = new AutomaticDoor();
        sensor.addListener(win);
        sensor.addListener(door);
        final List<String> type = Arrays.asList("sun", "rain");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Collections.shuffle(type);
                sensor.setWeatherType(type.get(0));
            }
        }, 0, 1000);
    }

}
