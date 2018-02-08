import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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

public class CyclicBarrierTest1 {

    private static final int THREAD_COUNT = 10;

    private final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(THREAD_COUNT, new Runnable() {
        public void run() {
            System.out.println("======>I am travel leader, go to nex step");
        }
    });

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < 10; i++) {
            new Thread(String.valueOf(i)) {
                public void run() {
                    try {
                        System.out.println("I am thread: " + this.getName() + ", I arrive place.");
                        CYCLIC_BARRIER.await();
                        System.out.println("I am thread: " + this.getName() + ", I bike.");
                        CYCLIC_BARRIER.await();
                        System.out.println("I am thread: " + this.getName() + ", I clumb montain.");
                        CYCLIC_BARRIER.await();
                        System.out.println("I am thread: " + this.getName() + ", I am in hotel.");
                        CYCLIC_BARRIER.await();
                        System.out.println("I am thread: " + this.getName() + ", I am going to home.");
                        CYCLIC_BARRIER.await();
                        System.out.println("I am thread: " + this.getName() + ", I am at home.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
