import java.util.concurrent.Exchanger;

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

public class ExchangerTest {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<String>();
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");
        ExchangerRunnable exchangerRunnable3 = new ExchangerRunnable(exchanger, "C");
        ExchangerRunnable exchangerRunnable4 = new ExchangerRunnable(exchanger, "D");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
        new Thread(exchangerRunnable3).start();
        new Thread(exchangerRunnable4).start();
    }

    static class ExchangerRunnable implements Runnable {

        Exchanger<String> exchanger = null;
        String object = null;

        public ExchangerRunnable(Exchanger<String> exchanger, String str) {
            this.exchanger = exchanger;
            object = str;
        }

        public void run() {
            try {
                String previous = object;

                object = this.exchanger.exchange(object);

                System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
