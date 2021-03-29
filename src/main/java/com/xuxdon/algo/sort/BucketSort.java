package com.xuxdon.algo.sort;

import com.xuxdon.algo.util.MyUtils;

public class BucketSort {

    /**
     * 计数排序
     *
     * 在计数的过程中元素会按值排号分散在计数数组中，最后将计数值不为 0 的元素拿出来，这个序列就是排好序的序列
     *
     * @param array 要处理的数组
     * @param left 起始位置
     * @param right 结束位置
     */
    public static void countSort(int[] array, int left, int right){
        int max = array[0];
        // 选出最大值
        for (int i=1; i<array.length; i++){
            max = Math.max(array[i], max);  //  max = array[i] > max ? array[i] : max;
        }

        int[] count = new int[max + 1];  // max = 9，则 count[] 下标从 0~9
        // 对每个出现的数进行计数；5 出现了 3 次则 count[5] = 3
        // count | 0 | 1 | 2 | 3 | ...    // 下标
        //       | 0 | 8 | 0 | 0 | ...    // 1 出现了 8 次
        for (int i=0; i<array.length; i++){
            count[array[i]]++;
        }

        int index = 0;  // array 数组的下标指针
        int element = 0;  // 被排序的各个元素
        int times = 0;  // 元素出现的次数
        for (element=0; element<count.length; element++){
            times = count[element];
            if (times != 0){  // 丢弃没有出现过的数；count[2] == 0 则数字 2 没有出现过
                for (int j=0; j<times; j++){
                    array[index] = element;  // 将出现过的元素从 count 中取出放回到 array 中，排序完成
                    index++;
                }
            }
        }
    }


    /**
     * 基数排序
     *
     * 从低到高，每一轮都按某数位排序，完成所有数位后排序完成
     * @param array 要处理的数组
     * @param left 起始位置
     * @param right 结束位置
     * @param digit 最大的数有多少十进制位
     */
    public static void radixSort(int[] array, int left, int right, int digit){
        final int radix = 10;  // 表示处理十进制数
        int i = 0, j = 0, num = 0;

        // 与原数组一样大的桶
        int[] bucket = new int[right - left + 1];

        // 第 d 轮循环之后，其结果是按第 d 位进桶再倒出的结果
        for (int d = 1; d <= digit; d++){  // 每一轮循环处理某一位

            // 在处理每一位时，为每一个数字出现的次数进行统计计数
            int[] countForEqRadix = new int[radix];  // Eq -> equal
            for (i = left; i <= right; i++){
                j = MyUtils.getDigit(array[i], d);  // 某个数字 array[i] 的第 d 位数字为 j
                 countForEqRadix[j]++;
            }

            // 计算所给数据中第 d 位 <= 十进制中某个数 i 的数值 的个数
            for (i = 1; i < radix; i++){
                countForEqRadix[i] = countForEqRadix[i] + countForEqRadix[i - 1];
            }
            int[] countForLeRadix = countForEqRadix;  // Le -> less or equal

            // 从右向左遍历 (反过来也可以但要改变代码)
            // 不管是 countForEqRadix 还是 countForLeRadix, 其都用自己的下标值对应十进制 0～9
            // countForLeRadix 是累加了前面十进制位数值的情况，这就意味着越大的十进制位数值 num 越大，在收获对应元素时也将该元素放到 bucket 的后面位置
            for (i = right; i >= left; i--){
                j = MyUtils.getDigit(array[i], d);
                num = countForLeRadix[j];  // 小于等于 array[i] 第 d 位数字 j 的数值共有 num 个；    不会超过原数组 / bucket 的元素数
                bucket[num - 1] = array[i];  // 桶的相应位置放入该元素
                countForEqRadix[j]--;  // 小于等于的计数数值减 1，以便下次将第 d 位同样为 j 的数值放到当前数的前(左)边
            }

            // 倒出，得出按第 d 位排序的结果
            for (i = left, j =0; i <= right; i++, j++){
                array[i] = bucket[j];
            }
        }
    }


}
