package com.xuxdon.algo.util;

public class MyUtils {

    /**
     * 实现交换数组 array 中下标为 a 和 b 的两个元素的功能
     */
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    /**
     * 获取十进制数 x 的第 d 位数
     * 1234 中的 1 是第 4 位数
     */
    public static int getDigit(int x, int d){
        return (x / ((int)Math.pow(10, d-1))) % 10;
    }

}
