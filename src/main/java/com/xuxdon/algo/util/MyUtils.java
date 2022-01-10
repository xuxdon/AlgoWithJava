package com.xuxdon.algo.util;

public class MyUtils {

    /**
     * 实现交换数组 array 中下标为 index1 和 index2 的两个元素的功能
     
     * @param array 目标元素所在的数组
     * @param index1 元素所在下标
     * @param index2 另一个元素的下标
     */
    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    /**
     * 获取十进制数 x 的第 d 位数
     * 1234 中的 1 是第 4 位数
     */
    public static int getDigit(int x, int d){
        return (x / ((int)Math.pow(10, d-1))) % 10;
    }

}
