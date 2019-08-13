package com.sun.problem.chapter_2;

import com.sun.common.BinaryTreeNode;
import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 题目：重建二叉树
 * 输入前序遍历的结果 和 中序遍历的结果，输出一个二叉树
 */
public class Problem_6_RebuildBinaryTreeNode {

    private static Logger logger = LoggerFactory.getLogger(Problem_6_RebuildBinaryTreeNode.class);

    public static void main(String[] args){
        Problem_6_RebuildBinaryTreeNode test = new Problem_6_RebuildBinaryTreeNode();
        BinaryTreeNode root = test.build(new int[]{1, 2, 4, 5, 3, 6, 7, 8, 9}, new int[]{4, 2, 5, 1, 7, 6, 9, 8, 3});
        root.preOrder();
        root.midOrder();
        root.postOrder();
    }

    public BinaryTreeNode build(int[] preArray, int[] midArray){
        if (preArray == null || midArray == null || preArray.length <= 0 || preArray.length != midArray.length){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = preArray[0];
        int index = indexOfArray(preArray[0], midArray);
        root.left = build(subArray(1, index, preArray), subArray(0, index - 1, midArray));
        root.right = build(subArray(index + 1, preArray.length - 1, preArray), subArray(index + 1, midArray.length - 1, midArray));
        return root;
    }

    private int indexOfArray(int value, int[] array){
        for (int i = 0; i < array.length; i ++){
            if (value == array[i]){
                return i;
            }
        }
        return -1;
    }

    private int[] subArray(int start, int end, int[] source){
        if (source == null || start < 0 || end >= source.length){
            return null;
        }
        int[] result = new int[end - start + 1];
        for (int i = 0; start <= end; i ++, start ++){
            result[i] = source[start];
        }
        return result;
    }
}
