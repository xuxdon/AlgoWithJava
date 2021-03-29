package com.xuxdon.algo.sort;


import com.xuxdon.algo.util.MyUtils;

public class InsertionSort {

    /**
     * 插入排序
     * @param array 需要排序的顺序表
     * @return 排好序的顺序表
     * r 从 1 增加到 N，每轮新加入的元素都需要在已排好序的序列中找到自己的位置
     */
    public static int[] sort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }

        for (int r=1; r<array.length; r++){  // r 自增一次就新纳入以一个新元素
            for(int i=r-1; i>=0; i--){  // i 指向前一个元素，如果新元素向前进那么 i 也自减，所以 i+1 始终指向新加入的元素
                if (array[i] > array[i+1]){  // array[i] > array[i+1] 则新加入的元素与前者交换同时 i 自减
                    MyUtils.swap(array, i, i+1);
                } else {
                    break;
                }
            }
//            System.out.println("本轮排序结果：" + Arrays.toString(array));
        }
        return array;
    }

}
