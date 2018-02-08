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

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice  implements MethodBeforeAdvice{

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before: method before...");
        System.out.println("before: invoke Info: ");
        System.out.println("before: method: " + method);
        System.out.println("before: arg: " + args);
        System.out.println("before: target object: " + target);
    }

}
