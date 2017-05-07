package com.stokey.algorithmdemo.Algorithm.util;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;

import java.util.Date;

/**
 * Created by stokey on 2017/5/7.
 */

public class Utils {

    public static  <T> T[] swap(T[] input,int start,int end){
        if (input == null || input.length < 0 || input.length < start ||
                input.length < end || start > end || start < 0|| end < 0){
            // TODO: input is error
            return null;
        }

        if(start == end){
            return input;
        }

        T temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        return input;
    }

    private static <T> void printF(String tag,T[] input,long startTime,long endTime,boolean printItem){
        if (printItem) {
            if (input != null && input.length > 0) {
                for (int i = 0; i < input.length; i++) {
                    System.out.println(tag + ":" + input[i]);
                }
            }
        }
        System.out.println(tag+": cost time = "+(endTime-startTime)+"ms");
    }

    public static <T extends Comparable<? super T>> void sort(String className, T[] input){
        sort(className,input,false);
    }

    public static <T extends Comparable<? super T>> void sort(String className, T[] input,boolean print){
        sort(className,input,print,false);
    }

    public static <T extends Comparable<? super T>> void sort(String className, T[] input,boolean print,boolean sortAdvance){
        long startTime = new Date().getTime();
        try {
            Class<ISort> classTemp = (Class<ISort>) Class.forName(className);
            ISort temp = classTemp.newInstance();
            if (sortAdvance){
                temp.sortAdvance(input);
            } else {
                temp.sort(input);
            }
            long endTime = new Date().getTime();
            printF(className,input,startTime,endTime,print);
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
