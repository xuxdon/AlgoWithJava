package com.xuxdon.algo.sort;

public class MergeSort{

    /**
     * 使用归并排序算法对序列进行升序排序
     * @param array 要处理的序列
     * @param left 开始的位置 (包含)
     * @param right 结束的位置 (包含)
     */
    public static void sort(int[] array, int left, int right){
        // 排除异常
        if (array == null || array.length == 0){
//            System.out.println("Something went wrong with your given array !");
            return;
        }

        // base case
        if (left == right){
            return;
        }

        int mid = left + ((right - left)>>1);  // 注意运算符优先级
        sort(array, left, mid);
        sort(array, mid+1, right);
        merge(array, left, mid, right);
    }


    /**
     * 双指针比较, 合并已排好的两个部分
     * @param array array 的 [left, mid] 和 [mid+1, right] 已经分别排好了序
     * @param left 起始位置
     * @param mid 中间位置
     * @param right 结束位置
     */
    private static void merge(int[] array, int left, int mid, int right){
        int[] container = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;

        for(i=0; (p1 <= mid) && (p2 <= right); i++){
            container[i] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }

        // 上述代码详解
        /*
        while((p1 <= mid) && (p2 <= right)){
            if (array[p1] <= array[p2]){
                container[i] = array[p1];
                p1++;
            } else {
                container[i] = array[p2];
                p2++;
            }
            i++;
        }
         */

        while(p1 <= mid){  // p1 = mid + 1 才算全部处理完左边
            container[i] = array[p1];
            p1++;
            i++;
        }
        while(p2 <= right){  // p2 = right 才算全部处理完右边
            container[i] = array[p2];
            p2++;
            i++;
        }

        // 小坑。这里只需要修改 array 相应的区域
        for(int k=0; k<container.length; k++){
            array[left + k] = container[k];
        }
    }
}
