package com.sun.problem.chapter_2;

import com.sun.common.ListNode;
import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

import java.util.Stack;

/**
 * 第五题
 * 链表
 * 题目：输入一个单向链表的头结点，从尾部到头打印出结点的值
 */
public class Problem_5_ReverseSinglyListNode {

    private static Logger logger = LoggerFactory.getLogger(Problem_5_ReverseSinglyListNode.class);

    public static void main(String[] args){
        Integer[] array = new Integer[]{1, 2};
        ListNode<Integer> listNode = ListNode.create(array);
        logger.printListNode(listNode);
        solution1(listNode);
        logger.println("使用递归: ");
        solution2(listNode);
        logger.println("");
        logger.println("反转列表: ");
        logger.printListNode(reverse(listNode));
    }

    /**
     * 如果面试官不给使用改变原来的链表
     *
     * 解法一
     *
     * 因为要从尾部往头部打印，即先进后出，符合栈结构，所以可以用栈来配合输出
     */
    public static void solution1(ListNode<Integer> head){
        ListNode<Integer> p = head;
        Stack<Integer> stack = new Stack<>();
        while (p != null){
            stack.push(p.value);
            p = p.next;
        }
        logger.print("Result: ");
        while (!stack.empty()){
            if (stack.size() == 1){
                logger.print(stack.pop() + " ;");
            }else {
                logger.print(stack.pop() + " -> ");
            }
        }
        logger.println("");
    }

    /**
     * 解法二
     *
     * 在solution1的思路上，不适用栈的情况，用递归也可以实现，递归其实就是方法栈的调用
     *
     * 递归，如果node.next为空，则打印
     *
     * @param listNode
     */
    public static void solution2(ListNode<Integer> listNode){
        if (listNode != null){
            solution2(listNode.next);
            logger.print(listNode.value + " -> ");
        }
    }

    /**
     * 第三种解法
     *
     * 如果可以改变链表的结构，即先反转列表再遍历
     *
     * 需要用到两个指针，当前cur和curPre指针
     * @param head
     */
    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        // 记录当前节点的下一个节点，第一个pre节点用head节点，当前节点为第二个节点
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp;
        while (cur.next != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur.next = pre;
        head.next = null;
        return cur;
    }
}
