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

public class PersonImpl implements Person {
    private String name;
    private int age;

    @Passport(testValue = "test@x.com")
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info() {
        System.out.println("name: " + name + ", age: " + age);
    }

    public void run() {
        if (age < 45) {
            System.out.println("I am young....");
        } else {
            System.out.println("I am old....");
        }
    }
}