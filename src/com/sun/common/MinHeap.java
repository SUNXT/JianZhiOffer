package com.sun.common;

/**
 * 最小堆结构
 */
public class MinHeap extends Heap{

    /**
     * 构造函数
     * @param maxHeapSize 堆大小
     */
    public MinHeap(int maxHeapSize){
        super(maxHeapSize);
    }

    /**
     * 构造函数 传入一个数组，直接构建堆
     * @param maxHeapSize 堆大小
     * @param array
     */
    public MinHeap(int maxHeapSize, int[] array){
        super(maxHeapSize, array);
    }

    /**
     * 下滑调整最小堆算法
     * 从节点start开始到m为止，自上向下比较，如果子女的值小于父节点的值，则子女节点中最小的值向上浮，然后继续向下比较，这样将一个集合局部调整为最小堆
     * @param start
     * @param m
     */
    @Override
    protected void siftDown(int start, int m){
        int i = start;
        // j是i的左子女位置
        int j = i * 2 + 1;
        int temp = heap[i];
        // 检查是否到最后位置
        while (j <= m){
            // 让j指向子女节点中最小者
            if (j < m && heap[j] > heap[j + 1]){
                j ++;
            }
            // 如果父节点已经小于子女节点了，跳出循环
            if (temp <= heap[j]) {
                break;
            }else {
                // 否则，则将子女节点中最小者上浮到父节点，i、j下降
                heap[i] = heap[j];
                i = j;
                j = i * 2 + 1;
            }
            heap[i] = temp;
        }
    }

    /**
     * 上滑调整
     * 从start节点开始到节点0为止，自下向上比较，如果子女的值小于父节点的值则互相交换，这样将集合重新调整为最小堆
     * @param start
     */
    @Override
    protected void siftUp(int start){
        int j = start;
        int i = (j - 1) / 2;
        int temp = heap[j];
        // 沿着父节点路径向上直达根节点
        while (j > 0){
            // 父节点值小，不调整
            if (heap[i] <= temp){
                break;
            }else {
                // 父节点值大，调整
                heap[j] = heap[i];
                j = i;
                i = (i - 1) / 2;
            }
        }
        heap[j] = temp;
    }
}
