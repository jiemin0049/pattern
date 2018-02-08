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
 *    Created on  09.10.2013
 *
 ************************************************************************/
package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("file:d:\\Entwicklung\\Automation-workspace\\patterns\\bin\\spring\\aop\\Beans.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("d:\\Entwicklung\\Automation-workspace\\patterns\\bin\\spring\\aop\\Beans.xml");
        Person p = (Person)context.getBean("person");
        p.info();
        System.out.println("===========================================");
        p.run();
    }
}
