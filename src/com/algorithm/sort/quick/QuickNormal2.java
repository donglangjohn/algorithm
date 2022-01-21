package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickNormal2 {

    public static void main(String[] args) {
        int[] unSortedArray = {6, 3, 8, 2, 9, 1};
        IntStream beforeSortStream = Arrays.stream(unSortedArray);
        beforeSortStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        quickSort(unSortedArray);
        IntStream afterSortStream = Arrays.stream(unSortedArray);
        afterSortStream.forEach(x -> System.out.print(x + " "));
    }

    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
        }
        sort(array, 0, len - 1);
    }
    
    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base�д�Ż�׼��
        int base = array[left];
        int i = left;
        int j = right;
        while (i != j) {
            // ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
            while (array[j] >= base && i < j) {
                j--;
            }

            // �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
            while (array[i] <= base && i < j) {
                i++;
            }

            // �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // ����׼���ŵ��м��λ�ã���׼����λ��
        array[left] = array[i];
        array[i] = base;

        // �ݹ飬�������׼����������ִ�к�����ͬ���Ĳ���
        // i��������Ϊ������ȷ���õĻ�׼ֵ��λ�ã������ٴ���
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

}
