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

public class CountDownLatchTest1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();
    }

    static class Waiter implements Runnable {

        CountDownLatch latch = null;

        public Waiter(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            try {
                System.out.println("Waiter waiting......");
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Waiter Released");
        }
    }

    static class Decrementer implements Runnable {

        CountDownLatch latch = null;

        public Decrementer(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {

            try {
                Thread.sleep(1000);
                System.out.println("decrementer count down....");
                this.latch.countDown();

                Thread.sleep(1000);
                System.out.println("decrementer count down....");
                this.latch.countDown();

                Thread.sleep(1000);
                System.out.println("decrementer count down....");
                this.latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
