package com.sun.sort;

import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 快速排序
 */
public class QuickSort {

    private static Logger logger = LoggerFactory.getLogger(QuickSort.class);

    public static void main(String[] args){
        int[] array = RandomArrayCreator.createArray(1, 100, 10);
        logger.printArray(array);
//        sort(array);
        logger.println(partition(array, 0, array.length - 1));
        logger.printArray(array);
    }

    public static void sort(int[] array){
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right){
        if (left < right){
            int index = partition(array, left, right);
            sort(array, left, index - 1);
            sort(array, index + 1, right);
        }
    }

    public static int partition(int[] array, int left, int right){
        if (array == null || left > right || left < 0 || right >= array.length){
            return -1;
        }
        // 基准数
        int value = array[left];
        // 从left 到 right进行划分，将比value小的放左边，比value大的放右边
        int valuePos = left;
        for (int i = left + 1; i <= right; ++ i){
            // 如果当前值小的话，则移动
            if (array[i] < value){
                valuePos ++;
                if (valuePos != left){
                    swap(array, valuePos, i);
                }
            }
        }
        array[left] = array[valuePos];
        array[valuePos] = value;
        return valuePos;
    }

    private static void swap(int[] array, int i, int k){
        if (array == null || i < 0 || i >= array.length || k < 0 || k >= array.length){
            return;
        }
        int temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }

}
