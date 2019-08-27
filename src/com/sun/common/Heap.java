package com.sun.common;

import java.security.InvalidParameterException;

public abstract class Heap {

    protected int[] heap;
    protected int maxHeapSize;
    protected int currentSize = 0;

    protected abstract void siftUp(int start);
    protected abstract void siftDown(int start, int m);

    /**
     * 构造函数
     * @param maxHeapSize 堆大小
     */
    public Heap(int maxHeapSize){
        if (maxHeapSize <= 0){
            throw new InvalidParameterException("maxHeapSize 不能小于0");
        }
        this.maxHeapSize = maxHeapSize;
        heap = new int[maxHeapSize];
    }

    /**
     * 构造函数 传入一个数组，直接构建堆
     * @param maxHeapSize 堆大小
     * @param array
     */
    public Heap(int maxHeapSize, int[] array){
        this(maxHeapSize);
        if (array.length > maxHeapSize){
            throw new InvalidParameterException("array比maxHeapSize的长度还大");
        }
        System.arraycopy(array, 0, heap, 0, array.length);
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
     * 插入一个新的值
     * @param value
     * @return
     */
    public boolean insert(int value){
        if (currentSize == maxHeapSize){
            return false;
        }
        heap[currentSize] = value;
        siftUp(currentSize);
        currentSize ++;
        return true;
    }

    /**
     * 删除最小值
     * @return
     */
    public int removeTop(){
        if (currentSize == 0){
            return 0;
        }
        int top = heap[0];
        // 用最后的元素填充根节点
        heap[0] = heap[currentSize - 1];
        heap[currentSize - 1] = 0;
        // 个数-1
        currentSize --;
        siftDown(0, currentSize - 1);
        return top;
    }

    /**
     * 获取整个堆数据
     * @return
     */
    public int[] getHeap(){
        return heap;
    }

    /**
     * 获取堆顶
     * @return
     */
    public int getTop(){
        return heap != null ? heap[0] : 0;
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
}
