import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.Semaphore;

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

public class SemaphoreTest {
    private final static Semaphore MAX_SEMA_PHORE = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int num = i;
            final Random radom = new Random();
            new Thread() {
                public void run() {
                    boolean acquired = false;
                    try {
                        MAX_SEMA_PHORE.acquire();
                        acquired = true;
                        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                        Calendar cal = Calendar.getInstance();
                        System.out.println("I am thread: " + num + " I get right." + dateFormat.format(cal.getTime()));
                        long time = 1000 * Math.max(1, Math.abs(radom.nextInt() % 10));
                        Thread.sleep(time);
                        System.out.println("I am thread: " + num + " I am finish! " + dateFormat.format(cal.getTime()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (acquired) {
                            MAX_SEMA_PHORE.release();
                        }
                    }
                }
            }.start();
        }
    }
}
