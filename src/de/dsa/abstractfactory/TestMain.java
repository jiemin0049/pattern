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
 *    Created on  25.07.2012
 *
 ************************************************************************/
package de.dsa.abstractfactory;

public class TestMain {

    private static String concreteFactory = "de.dsa.abstractfactory.ListFactory";
    //private static String concreteFactory = "de.dsa.abstractfactory.TableFactory";

    public static void main(String[] args) {
        Factory factory = Factory.getFactory(concreteFactory);

        Link china_daily = factory.createLink("China Daily", "www.chinadaily.com.cn");
        Link az = factory.createLink("AZ Aachen", "www.az.de");
        Link google = factory.createLink("Google", "www.google.de");
        Link us_yahoo = factory.createLink("Yahoo US", "www.yahoo.com");
        Link cn_yahoo = factory.createLink("Yahoo CN", "www.yahoo.cn");

        Tray trayNews = factory.createTray("News");
        trayNews.add(az);
        trayNews.add(china_daily);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(cn_yahoo);


        Tray trayGoogle = factory.createTray("Google");
        trayGoogle.add(google);


        Page page = factory.createPage("Link_Page", "jz");
        page.add(trayNews);
        page.add(trayYahoo);
        page.add(trayGoogle);
        page.output();

    }

}
