package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/1.
 */

public class E34UglyNumber {
    /**
     * 把只包含因子2，3和5的数称作丑数（习惯上把1当作丑数）
     *
     *
     * @param index
     * @return
     */
    public static int getUglyNumber(int index) {
        if(index <=0){
            throw new RuntimeException("input error");
        }
        int[] result = new int[index];
        result[0] = 1;
        int nextIndex=1;
        int p2 =0,p3 =0,p5=0;
        while (nextIndex < index){
            int min = min(result[nextIndex]*2,result[nextIndex]*3,result[nextIndex]*5);
            result[nextIndex] = min;
            while (result[nextIndex]*2<=result[nextIndex]){

            }
        }
    }

    /**
     * 判断是否是丑数
     * @param num
     * @return
     */
    private static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
