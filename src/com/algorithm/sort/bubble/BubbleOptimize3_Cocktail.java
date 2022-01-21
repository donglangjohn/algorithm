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
        // ���˴˵�����������󽻻�����
        int lastLeftExchangeIndex = 0;
        int lastRightExchangeIndex = 0;
        // ��������߽�ĳ�ʼֵ
        int leftSortBorder = 0;
        int rightSortBorder = unSortedArray.length - 1;

        for (int i = 0; i < unSortedArray.length / 2; i++) { // ���ֻ��Ҫ��һ�룬��Ϊ�ڲ����ҵ��Բ�ı߽�index

            boolean isChangeElement = false;
            // ��ʼ���ұ߽� ��������
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (unSortedArray[j] > unSortedArray[j + 1]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j + 1];
                    unSortedArray[j + 1] = temp;
                    isChangeElement = true;
                    lastRightExchangeIndex = j;
                }
            }

            rightSortBorder = lastRightExchangeIndex;// �ҵ��ұ߽�
            if (!isChangeElement) {
                break;
            }

            isChangeElement = false;// ���ñ��
            // ��ʼ����߽� ��������
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (unSortedArray[j - 1] > unSortedArray[j]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j - 1];
                    unSortedArray[j - 1] = temp;
                    isChangeElement = true;
                    lastLeftExchangeIndex = j;
                }
            }

            leftSortBorder = lastLeftExchangeIndex; // �ҵ���߽�
            if (!isChangeElement) {
                break;
            }

        }

    }
}
