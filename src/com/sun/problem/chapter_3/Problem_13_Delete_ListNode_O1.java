package com.sun.problem.chapter_3;

import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 使用O(1)的时间复杂度删除单向链表中的某一个节点
 */
public class Problem_13_Delete_ListNode_O1 {

    private static Logger logger = LoggerFactory.getLogger(Problem_13_Delete_ListNode_O1.class);

    public static void main(String[] args){
        testCase(1, 1);
        testCase(5, 2);
        testCase(5,5);
        testCase(5, 3);
        testCase(5, 1);
    }

    public static void testCase(int n, int p){
        logger.println("");
        logger.println("n = " + n + " p = " + p);
        ListNode head = new ListNode(1);
        ListNode q = head,pNode = head;
        logger.println("原链表：");
        if (n == 1){
            logger.println(1 + ";");
        }else {
            logger.print(1 + "->");
        }
        for (int i = 2; i <= n; ++ i){
            if (i != n){
                logger.print(i + "->");
            }else {
                logger.println(i + ";");
            }
            q.next = new ListNode(i);
            q = q.next;
            if (p == i){
                pNode = q;
            }
        }

        ListNode result = deleteNode(head, pNode);
        logger.print("删除后的链表：");
        if (result == null){
            logger.println("null");
            return;
        }
        while (result != null){
            if (result.next == null){
                logger.println(result.value + ";");
            }else {
                logger.print(result.value + "->");
            }
            result = result.next;
        }
    }

    public static class ListNode{
        int value;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     *
     * 如果普通的查询删除的话，需要的时间复杂度是O(n)，因为是单向链表，要找到对应需要删除的节点，需要先使用循环遍历，即需要O(n)的时间
     * 但是，如果要实现O(1)的情况的话，则不能遍历，那需要怎么做呢？
     * 这里，我们已经知道了pNode，这时候，如果我们不删除pNode，而是删除pNode->next，然后再把pNode->next的值赋值到原先的pNode，这样也达到效果！
     *
     * 当然，我们要考虑，单链表只有一个节点的时候，我们删除完，需要将head设置为空
     * 当删除的节点为最后一个节点的时候，我们只能遍历链表进行删除
     *
     * @param head 链表的头指针
     * @param pNode 需要删除的节点
     */
    public static ListNode deleteNode(ListNode head, ListNode pNode){
        if (head == null || pNode == null){
            return head;
        }
        // 只有一个节点，同时pNode不为空，说明，此时，pNode == head，删除之后需要至空
        if (head.next == null){
            return null;
        }
        // 如果pNode为链表尾部，需要从head遍历
        if (pNode.next == null){
            ListNode q = head;
            while (q.next != null){
                if (q.next == pNode){
                    // q为pNode的前一个节点，进行删除操作
                    q.next = null;
                    break;
                }
                q = q.next;
            }
        }else {
            // 非尾部的情况
            pNode.value = pNode.next.value;
            pNode.next = pNode.next.next;
        }
        return head;
    }
}
