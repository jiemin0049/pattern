import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
 *    Created on  08.10.2014
 *
 ************************************************************************/

public class SampleChineseSort {
    private final static Comparator CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINESE);

    public static void main(String[] args) {
        sortArray();
        sortList();
    }

    private static void sortList() {
        List<String> list = Arrays.asList("张三", "李四", "王五");
        Collections.sort(list, CHINA_COMPARE);
        for (String str : list) {
            System.out.println(str);
        }
    }

    private static void sortArray() {
        String[] arr = { "张三", "李四", "王五" };
        Arrays.sort(arr, CHINA_COMPARE);
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
