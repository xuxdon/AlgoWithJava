package com.xuxdon.algo.sort;

import com.xuxdon.algo.util.MyUtils;

public class BubbleSort {

    /**
     * 冒泡升序
     * 在 [0, r) 区间上对数组进行升序冒泡
     * 每次从下标 0 的元素开始，遇到比他小的就交换，遇到大则指针直接指向大者再继续向后比较；每一轮都会把 [0, r) 区间中的最大元素带到 r 位置；最终实现全部排序
     * r 取开区间是为了避免 r+1 越界
     * 为保证稳定性，比较时不取等号，则相等的元素不会互换
     *
     * 时间复杂度分析：
     * 外循环的 r 值：         1 <- ... ... <- N-2 <- N-1 <- N
     * 内循环的 i 值： 0 -> r
     * 总复杂度 N + (N-1) + (N-2) + ... + 1, 即 O(N^2)
     *
     * @param array 被排序的数组
     */
    public static boolean sort(int[] array){
        if(array == null || array.length < 2){
            return false;
        }

        for (int r=(array.length - 1); r>0; r--){  // r 指示本轮循环要解决的那个位置
            for (int i=0; i<r; i++){
                if (array[i] > array[i+1]){  // 使得每次比较时第 i 位的元素始终比前面的 i-1 个元素大。最后一轮比较 array[r-1] 和 array[r]
                    MyUtils.swap(array, i, i+1);  // 交换 array[a] 和 array[b]
                }
            }
        }
        return true;
    }

}
