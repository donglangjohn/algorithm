package com.algorithm.sort.bubble;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class BubbleOptimize2 {
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

        int lastExchangeIndex = 0; //本趟循环的最后一次交换坐标
        int sortBorder = unSortedArray.length - 1;//内层循环的边界

        for (int i = 0; i < unSortedArray.length - 1; i++) {

            boolean isChangeElement = false;

            for (int j = 0; j < sortBorder; j++) { //右侧边界，每一次都是根据上次的最后一次change index为准
                if (unSortedArray[j] > unSortedArray[j + 1]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j + 1];
                    unSortedArray[j + 1] = temp;
                    isChangeElement = true;
                    lastExchangeIndex = j; //发生了元素交换，记录下本次的index
                }
            }

            sortBorder = lastExchangeIndex;//内层循环一趟后，设置下一趟循环的右侧边界index
            if (!isChangeElement) {
                break;
            }
        }

    }
}
