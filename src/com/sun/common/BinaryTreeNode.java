package com.sun.common;

import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 二叉树
 */
public class BinaryTreeNode {

    private Logger logger = LoggerFactory.getLogger(this);

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    /**
     * 前序遍历
     */
    public void preOrder() {
        logger.println("二叉树前序遍历");
        preOrder(this);
        logger.println("");
    }

    private void preOrder(BinaryTreeNode node) {
        if (node != null) {
            logger.print(node.value + " ,");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void midOrder() {
        logger.println("二叉树中序遍历");
        midOrder(this);
        logger.println("");
    }

    private void midOrder(BinaryTreeNode node) {
        if (node != null){
            midOrder(node.left);
            logger.print(node.value + " ,");
            midOrder(node.right);
        }
    }

    public void postOrder(){
        logger.println("二叉树后序遍历");
        postOrder(this);
        logger.println("");
    }

    private void postOrder(BinaryTreeNode node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            logger.print(node.value + " ,");
        }
    }
}

