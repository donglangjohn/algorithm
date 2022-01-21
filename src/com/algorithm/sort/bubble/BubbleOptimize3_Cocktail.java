package com.algorithm.sort.bubble;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class BubbleOptimize3_Cocktail {
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
        if (Objects.isNull(unSortedArray) || unSortedArray.length < 2) {
            return;
        }
        // 本趟此的左右两侧最后交换坐标
        int lastLeftExchangeIndex = 0;
        int lastRightExchangeIndex = 0;
        // 左右两侧边界的初始值
        int leftSortBorder = 0;
        int rightSortBorder = unSortedArray.length - 1;

        for (int i = 0; i < unSortedArray.length / 2; i++) { // 外层只需要跑一半，因为内部会找到对侧的边界index

            boolean isChangeElement = false;
            // 开始找右边界 从左往右
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (unSortedArray[j] > unSortedArray[j + 1]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j + 1];
                    unSortedArray[j + 1] = temp;
                    isChangeElement = true;
                    lastRightExchangeIndex = j;
                }
            }

            rightSortBorder = lastRightExchangeIndex;// 找到右边界
            if (!isChangeElement) {
                break;
            }

            isChangeElement = false;// 重置标记
            // 开始找左边界 从右往左
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (unSortedArray[j - 1] > unSortedArray[j]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j - 1];
                    unSortedArray[j - 1] = temp;
                    isChangeElement = true;
                    lastLeftExchangeIndex = j;
                }
            }

            leftSortBorder = lastLeftExchangeIndex; // 找到左边界
            if (!isChangeElement) {
                break;
            }

        }

    }
}
