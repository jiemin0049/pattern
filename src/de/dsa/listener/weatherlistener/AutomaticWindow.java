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

public class AutomaticWindow implements WeatherListener {

    public void performed(WeatherEvent e) {
        if (e.getWeather().equals("sun")) {
            System.out.println("sun! open window");
        } else if (e.getWeather().equals("rain")) {
            System.out.println("rain! close window");
        }
    }
}
