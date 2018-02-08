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
 *    Created on  11.10.2013
 *
 ************************************************************************/
package spring.aop;

import java.lang.reflect.Method;

public class PassportTest {

    @Passport(testValue = "ffffffffff")
    public void myMethodsAnnotation() {
        System.out.println("");
    }

    public static void main(String[] args) {
        Method[] methods = PassportTest.class.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Passport.class)) {
                Passport p = m.getAnnotation(Passport.class);
                System.out.println("method:" + m.getName());
                System.out.println("required():" + p.required());
                System.out.println("testValue():" + p.testValue());
            }
        }
    }

}
