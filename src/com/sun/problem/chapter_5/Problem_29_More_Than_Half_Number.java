package com.sun.problem.chapter_5;

import com.sun.sort.QuickSort;
import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

public class Problem_29_More_Than_Half_Number {

    private static Logger logger = LoggerFactory.getLogger(Problem_29_More_Than_Half_Number.class);

    public static void main(String[] args){
        int[] array = new int[]{3, 3, 4, 2, 4, 4, 3, 4, 3, 3, 3, 5, 3, 5, 3, 3};
        logger.println("array length = " + array.length);
        logger.printArray(array);
        logger.println(solution1(array));
        logger.println(solution2(array));
    }

    /**
     * O(n)时间复杂度，数组不会被改动
     * 我们用times来记录数字出现的次数，result表示最终的结果，遍历整个数组，如果times为0，则将当前数字赋值给result，否则，判断当前数字，如果等于result，则times++，否则times--
     * 原理：如果该数大于数组个数的一半，则最终的times次数为大于等于1的，因为，这个数的times要比其他数字的times总和大，所以，times(result) - times(other) >= 1，上面的操作，即，用result的次数去抵消其他数字的次数
     * @param array
     * @return
     */
    public static int solution1(int[] array){
        if (array == null || array.length < 1){
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; ++ i){
            if (times == 0){
                result = array[i];
                times = 1;
            }else if (result == array[i]){
                times ++;
            }else {
                times --;
            }
        }
        logger.println(result);
        if (!checkMoreThanHalfNumber(array, result)){
            return 0;
        }
        return result;
    }

    /**
     * 使用划分算法实现，时间复杂度为O(n)，但是改动了原来数组元素
     * @param array
     * @return
     */
    public static int solution2(int[] array){
        int middle = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        int k = QuickSort.partition(array, start, end);
        while (k != middle){
            if (k > middle){
                // 在 start - k范围内
                end = k - 1;
            }else {
                // 在 k - end 范围内
                start = k +1;
            }
            k = QuickSort.partition(array, start, end);
        }
        int result = array[middle];
        if (!checkMoreThanHalfNumber(array, result)){
            return 0;
        }
        return result;
    }

    /**
     * 检验数字是否合法，是否大于一半
     * @param array
     * @param number
     * @return
     */
    public static boolean checkMoreThanHalfNumber(int[] array, int number){
        int times = 0;
        for (int anArray : array) {
            if (anArray == number) {
                times++;
            }
        }
        return times > array.length / 2;
    }
}
