package com.xuxdon.algo.sort;

import org.junit.Test;

import java.util.Arrays;

public class PlayGround {

    @Test
    public void testSort(){
        int[] array = new int[]{1, 19, 16, 28, 105, 3, 24};
        System.out.println(BubbleSort.bubbleSort(array));
        System.out.println(Arrays.toString(array));
    }
}
