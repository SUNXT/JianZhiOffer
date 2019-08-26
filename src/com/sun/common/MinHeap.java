package com.sun.common;

import java.security.InvalidParameterException;

/**
 * 最小堆结构
 */
public class MinHeap {

    private int[] data;
    private int maxHeapSize;
    private int currentSize = 0;

    /**
     * 构造函数
     * @param maxHeapSize 堆大小
     */
    public MinHeap(int maxHeapSize){
        if (maxHeapSize <= 0){
            throw new InvalidParameterException("maxHeapSize 不能小于0");
        }
        this.maxHeapSize = maxHeapSize;
        data = new int[maxHeapSize];
    }

    /**
     * 构造函数 传入一个数组，直接构建堆
     * @param maxHeapSize 堆大小
     * @param array
     */
    public MinHeap(int maxHeapSize, int[] array){
        this(maxHeapSize);
        if (array.length > maxHeapSize){
            throw new InvalidParameterException("array比maxHeapSize的长度还大");
        }
        System.arraycopy(array, 0, data, 0, array.length);
        currentSize = array.length;
        // 下滑调整构建最小堆
        int currentPos = (currentSize - 2) / 2;//找到最初调整位置，最后的分支父节点
        // 自底向上逐步扩大形成堆
        while (currentPos >= 0){
            // 局部自上向下下滑调整
            siftDown(currentPos, currentSize - 1);
            // 再向前换一个分支节点
            currentPos --;
        }
    }

    /**
     * 获取堆顶
     * @return
     */
    public int getMin(){
        return data[0];
    }

    /**
     * 获取data
     * @return
     */
    public int[] getData(){
        return data;
    }

    /**
     * 是否堆已满
     * @return
     */
    public boolean isFull(){
        return currentSize == maxHeapSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * 插入一个新的值
     * @param value
     * @return
     */
    public boolean insert(int value){
        if (currentSize == maxHeapSize){
            return false;
        }
        data[currentSize] = value;
        siftUp(currentSize);
        currentSize ++;
        return true;
    }

    /**
     * 删除最小值
     * @return
     */
    public int removeMin(){
        if (currentSize == 0){
            return 0;
        }
        int min = data[0];
        // 用最后的元素填充根节点
        data[0] = data[currentSize - 1];
        data[currentSize - 1] = 0;
        // 个数-1
        currentSize --;
        siftDown(0, currentSize - 1);
        return min;
    }

    /**
     * 下滑调整最小堆算法
     * 从节点start开始到m为止，自上向下比较，如果子女的值小于父节点的值，则子女节点中最小的值向上浮，然后继续向下比较，这样将一个集合局部调整为最小堆
     * @param start
     * @param m
     */
    private void siftDown(int start, int m){
        int i = start;
        // j是i的左子女位置
        int j = i * 2 + 1;
        int temp = data[i];
        // 检查是否到最后位置
        while (j <= m){
            // 让j指向子女节点中最小者
            if (j < m && data[j] > data[j + 1]){
                j ++;
            }
            // 如果父节点已经小于子女节点了，跳出循环
            if (temp <= data[j]) {
                break;
            }else {
                // 否则，则将子女节点中最小者上浮到父节点，i、j下降
                data[i] = data[j];
                i = j;
                j = i * 2 + 1;
            }
            data[i] = temp;
        }
    }

    /**
     * 上滑调整
     * 从start节点开始到节点0为止，自下向上比较，如果子女的值小于父节点的值则互相交换，这样将集合重新调整为最小堆
     * @param start
     */
    private void siftUp(int start){
        int j = start;
        int i = (j - 1) / 2;
        int temp = data[j];
        // 沿着父节点路径向上直达根节点
        while (j > 0){
            // 父节点值小，不调整
            if (data[i] <= temp){
                break;
            }else {
                // 父节点值大，调整
                data[j] = data[i];
                j = i;
                i = (i - 1) / 2;
            }
        }
        data[j] = temp;
    }
}
