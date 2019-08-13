package com.sun.common;

/**
 * 单向链表
 * @param <V>
 */
public class ListNode<V> {
    public V value;
    public ListNode next;

    public static ListNode create(Object[] array){
        if (array == null || array.length == 0){
            return null;
        }
        ListNode head;
        ListNode cur = new ListNode();
        cur.value = array[0];
        head = cur;
        for (int i = 1; i < array.length; i ++){
            cur.next = new ListNode();
            cur.next.value = array[i];
            cur = cur.next;
        }
        return head;
    }
}
