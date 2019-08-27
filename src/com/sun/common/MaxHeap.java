package com.sun.common;

/**
 * 最大堆
 */
public class MaxHeap extends Heap{

    public MaxHeap(int maxHeapSize){
        super(maxHeapSize);
    }

    public MaxHeap(int maxHeapSize, int[] array){
        super(maxHeapSize, array);
    }


    /**
     * 下滑调整最小堆算法
     * 从start节点开始到m为止，自上向下比较，如果子女及诶单的值大于父节点的值，则子女节点中最大的值向上浮
     * 然后继续向下比较，这样将一个集合局部调整为一个最大堆
     * @param start
     * @param m
     */
    @Override
    protected void siftDown(int start, int m){
        int i = start;
        // 左子女的位置
        int j = i * 2 + 1;
        int temp = heap[i];
        // 检查是否到最后一个节点
        while (j <= m){
            // 让j指向子女节点中最大者
            if (j < m && heap[j] < heap[j + 1]) {
                j++;
            }
            // 如果父节点比子女节点的值大，跳出循环
            if (temp >= heap[j]){
                break;
            }else {
                // 否则，将子女中最大的值上浮到父节点，同时，i， j下滑
                heap[i] = heap[j];
                i = j;
                j = i * 2 + 1;
            }
        }
        heap[i] = temp;
    }

    /**
     * 上滑调整
     * 从start节点开始到节点0结束，自下向上比较，如果子女节点大于父节点的值，则将子女节点上浮
     * 这样将集合重新调整为最大堆
     * @param start
     */
    @Override
    protected void siftUp(int start){
        int j = start;
        int i = (j - 1) / 2;
        int temp = heap[j];
        while (j > 0){
            // 父节点的值大，不调整
            if (heap[i] >= temp){
                break;
            }else {
                // 父节点向下调整
                heap[j] = heap[i];
                j = i;
                i = (i - 1) / 2;
            }
        }
        heap[j] = temp;
    }
}
