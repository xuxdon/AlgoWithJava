package com.xuxdon.algo.sort;

import com.xuxdon.algo.util.MyUtils;

public class BigHeapSort {

    /**
     * 通过大根堆排序将一个无序数组变成递增数组
     *
     * 排序过程就是在数组中实现大根堆，让所有元素构成大根堆，再存入数组中；
     * 每次弹出最大元素后，都要重新调整以保持大根堆结构
     * 大根堆用尽时，排序完毕
     *
     * @param array 要排序的数组
     */
    public static void sort(int[] array){
        if (array == null || array.length < 2){
            return;
        }
        // 认为当前数组表达表达的是一颗完全二叉树，通过从下到上对每一层的每个节点都进行下沉操作，使每个子树都符合大根堆结构的要求
        for (int i = array.length - 1; i >= 0; i--){
            heapify(array, i, array.length);
        }
        // 从堆中不断获取最大值，直到堆被用完
        int heapSize = array.length;
        while (heapSize > 0){
            MyUtils.swap(array, 0, --heapSize);
            heapify(array, 0, heapSize);
        }
    }


    /**
     * 下沉
     * 使处于 index 的元素与子节点比较并尽量下沉
     * @param array    存储大根堆结构的数组
     * @param index    要下沉的元素的下标
     * @param heapSize 堆的元素总数
     */
    public static void heapify(int[] array, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {  // 如果算出的左孩子下标大于等于 heapSize，则表明该节点没有子节点
            // 找该节点左右孩子中较大的
            int indexOfLargest = (left + 1 < heapSize) && (array[left] < array[left + 1]) ?
                    left + 1  // 右孩子存在，且比左孩子大
                    : left;   // 右孩子不存在，或者左孩子更大
            // 该节点与最大的孩子节点 PK
            indexOfLargest = (array[index] > array[indexOfLargest]) ? index : indexOfLargest;

            // 情况 1 : 该节点最大，该当父节点，不再下沉
            if (indexOfLargest == index) {
                break;
            }
            // 情况 2 : 子节点更大，该节点继续下沉
            MyUtils.swap(array, index, indexOfLargest);
            index = indexOfLargest;  // 该节点来到曾经的大孩子的位置
            left = 2 * index + 1;  // 找到左孩子，继续循环
        }
    }

}
