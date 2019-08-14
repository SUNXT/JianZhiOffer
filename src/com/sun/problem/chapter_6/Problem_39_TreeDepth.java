package com.sun.problem.chapter_6;

import com.sun.common.BinaryTreeNode;
import com.sun.problem.chapter_2.Problem_6_RebuildBinaryTreeNode;
import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 求二叉树的深度
 * 输入一颗二叉树的根节点，求该树的深度。深度即从根节点到叶子节点的最长路径，最长路径的长度即二叉树的深度。
 *
 * 思路：
 * 如果树只有一个节点，那深度为 1
 * 如果树有左右子树，则深度为 2
 * 那如果左子树有的深度 n，右子树的深度为 m，此时，depth(root) = n > m ? n + 1 : m + 1
 * 即，从子树中取出最大的深度加上根数即树的深度
 *
 */
public class Problem_39_TreeDepth {

    private static Logger logger = LoggerFactory.getLogger(Problem_39_TreeDepth.class);

    public static void main(String[] args){
        Problem_6_RebuildBinaryTreeNode test = new Problem_6_RebuildBinaryTreeNode();
        BinaryTreeNode root = test.build(new int[]{1, 2, 4, 5, 3, 6, 7, 8, 9}, new int[]{4, 2, 5, 1, 7, 6, 9, 8, 3});
        BinaryTreeNode root1 = test.build(new int[]{1, 2, 4, 5, 3, 6}, new int[]{4, 2, 5, 1, 6, 3});
        logger.println(treeDepth(root));
        logger.println(treeDepth(root1));
    }

    /**
     * 用递归的思路求，其实求二叉树的深度，depth(root) = n > m ? n + 1 : m + 1
     * @param treeNode
     * @return
     */
    public static int treeDepth(BinaryTreeNode treeNode){
        if (treeNode != null){
            int leftDepth = treeDepth(treeNode.left);
            int rightDepth = treeDepth(treeNode.right);
            return leftDepth > rightDepth ? 1 + leftDepth : 1 + rightDepth;
        }
        // 如果节点为空，返回 0
        return 0;
    }
}
