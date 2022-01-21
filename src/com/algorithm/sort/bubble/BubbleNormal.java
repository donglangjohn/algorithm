package com.algorithm.sort.bubble;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class BubbleNormal {
    public static void main(String[] args) {
        
        int[] unSortedArray = {6, 3, 8, 2, 9, 1};

        IntStream beforeSortStream = Arrays.stream(unSortedArray);
        beforeSortStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        sort(unSortedArray);

        IntStream afterSortStream = Arrays.stream(unSortedArray);
        afterSortStream.forEach(x -> System.out.print(x + " "));

    }

    private static void sort(int[] unSortedArray) {

        //边界检查
        if (Objects.isNull(unSortedArray) || unSortedArray.length < 2) {
            return;
        }

        for (int i = 0; i < unSortedArray.length - 1; i++) { //外层循环控制排序几趟，例如2个元素，需要2趟
            for (int j = 0; j < unSortedArray.length - 1 - i; j++) {//内层循环控制每一趟需要比较的元素并交换位置
                if (unSortedArray[j] > unSortedArray[j + 1]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j + 1];
                    unSortedArray[j + 1] = temp;
                }
            }
        }

    }
}
