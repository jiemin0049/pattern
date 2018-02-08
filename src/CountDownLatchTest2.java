import java.util.concurrent.CountDownLatch;

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
 *    Created on  14.10.2014
 *
 ************************************************************************/

public class CountDownLatchTest2 {
    private final static int GROUP_SIZE = 5;

    public static void main(String[] args) {
        processOneGroup("Group 1");
        processOneGroup("Group 2");
    }

    private static void processOneGroup(final String groupName) {
        final CountDownLatch start_count_down = new CountDownLatch(1);
        final CountDownLatch end_count_down = new CountDownLatch(GROUP_SIZE);
        System.out.println("==========================>\nGroup:" + groupName + ", game begins:");
        for (int i = 0; i < GROUP_SIZE; i++) {
            new Thread(String.valueOf(i)) {
                public void run() {
                    System.out.println("Group:[" + groupName + "], I am hread: " + this.getName() + ", I am ready!");
                    try {
                        start_count_down.await();//Waiting for signal, start_count_down.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Group:[" + groupName + "], I am thread: " + this.getName() + ", I am finish!");
                    end_count_down.countDown();
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("everybody readyyyyy!");
        start_count_down.countDown();//begin to run
        try {
            end_count_down.await();//wait all runner finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Group " + groupName + " Game end!");
    }
}
