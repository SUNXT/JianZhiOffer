package com.sun.problem.chapter_5;

import com.sun.common.MinHeap;
import com.sun.sort.QuickSort;
import com.sun.sort.RandomArrayCreator;
import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 求数组中最小k个数
 */
public class Problem_30_K_Least_Numbers {

    private static Logger logger = LoggerFactory.getLogger(Problem_30_K_Least_Numbers.class);

    public static void main(String[] args){
        int[] array = RandomArrayCreator.createArray(0, 10, 10);
        logger.printArray(array);
        logger.printArray(solution2(array, 4));
//        int[] array = new int[]{53, 17, 78, 9, 45, 65, 87, 23};
//        logger.printArray(array);
//        MinHeap heap = new MinHeap(array.length, array);
//        logger.printArray(heap.getData());
//        MinHeap minHeap = new MinHeap(array.length);
//        for (int v: array){
//            minHeap.insert(v);
//        }
//        logger.printArray(minHeap.getData());

    }


    /**
     * 改变了源数组，适用于少量数据
     * 基于划分算法实现O(n)时间复杂度
     * @param array
     * @param k
     * @return
     */
    public static int[] solution1(int[] array, int k){
        if (array == null || k < 0 || k > array.length){
            return null;
        }
        // 如果刚好k等于数组的长度，直接返回数组
        if (k == array.length){
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        int index = QuickSort.partition(array, left, right);
        while (index != k - 1){
            if (index < k - 1){
                left = index + 1;
            }else {
                right = index -1;
            }
            index = QuickSort.partition(array, left, right);
        }
        int[] result = new int[k];
        System.arraycopy(array, 0, result, 0, k);
        return result;
    }

    /**
     * 适用于处理大量数据且不改变源数组
     * 使用堆结构，使用最大堆实现时间复杂度为 n*log(k)
     * @param array
     * @param k
     * @return
     */
    public static int[] solution2(int[] array, int k){
        if (array == null || k < 0 || k > array.length){
            return null;
        }
        // 如果刚好k等于数组的长度，直接返回数组
        if (k == array.length){
            return array;
        }
        // 构造一个个数为k的最小堆
//        MinHeap minHeap = new MinHeap(k);
//        // 遍历数组，同时将每个数与堆的最小值比较，如果比堆的最小值还小，则插入
//        for (int value: array){
//            if (!minHeap.isFull()){
//                minHeap.insert(value);
//            }else {
//                if (value >= minHeap.getMin()){
//                    minHeap.removeMin();
//                    minHeap.insert(value);
//                }
//            }
//        }
        return null;
    }
}
