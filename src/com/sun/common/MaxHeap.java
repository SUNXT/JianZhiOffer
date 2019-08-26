package com.sun.common;

import java.security.InvalidParameterException;

/**
 * 最大堆
 */
public class MaxHeap {

    private int maxHeapSize;
    private int currentSize;

    public MaxHeap(int maxHeapSize){
        if (maxHeapSize <= 0){
            throw new InvalidParameterException("maxHeapSize 不能小于0");
        }
        this.maxHeapSize = maxHeapSize;
    }

    public MaxHeap(int maxHeapSize, int[] array){
        this(maxHeapSize);
        if (array.length > maxHeapSize){
            throw new InvalidParameterException("array比maxHeapSize的长度还大");
        }
        System.arraycopy(array, 0, array, 0, array.length);
        currentSize = array.length;
    }

    private void siftDown(int start, int m){

    }
}
