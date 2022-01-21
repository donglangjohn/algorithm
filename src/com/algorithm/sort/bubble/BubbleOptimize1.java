package com.algorithm.sort.bubble;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class BubbleOptimize1 {
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

        for (int i = 0; i < unSortedArray.length - 1; i++) {

            boolean isChangeElement = false;//Ԫ���Ƿ�������

            for (int j = 0; j < unSortedArray.length - 1 - i; j++) {
                if (unSortedArray[j] > unSortedArray[j + 1]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j + 1];
                    unSortedArray[j + 1] = temp;
                    isChangeElement = true; //�����˽��������ø�ֵΪ true
                }
            }

            if (!isChangeElement) { //���û�з���Ԫ�ؽ�������Ϊ��������ɣ�������ǰ��������ѭ��
                break;
            }
        }

    }
}
