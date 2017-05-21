package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 */

public class B03FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 6));
    }

    public static boolean find(int[][] input,int target){
        // TODO:检测输入合法性
        int rows = input.length;
        int cols = input[0].length;
        /* 二维数组找 7。从右上角节点开始
        1   2   8   9          1   2   8         1   2
        2   4   9   12    ===> 2   4   9    ===> 2   4   ===> 2   4    ===> 4   7
        4   7   10  13         4   7   10        4   7        4   7
        6   8   11  15         6   8   11        6   8        6   8         6   8
        */
        int row = 0;
        int col = cols-1;
        while (col >= 0 && row < rows){
            if (input[row][col] == target){
                return true;
            } else if (input[row][col] < target){
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
