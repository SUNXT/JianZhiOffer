package com.sun.utils;

import com.sun.common.ListNode;

import java.util.Date;

public class Logger {

    private  String mTag = "";

    public Logger(String tag){
        mTag = tag;
    }

    private static String getTime(){
        Date date = new Date(System.currentTimeMillis());
        return date.toLocaleString();
    }

    public void d(String msg){
        System.out.println(getTime() + "? D/" + mTag + ": " + msg);
    }

    public void print(Object msg){
        System.out.print(String.valueOf(msg));
    }

    public void println(Object msg){
        System.out.println(String.valueOf(msg));
    }

    public void printArray(int[] objects){
        if (objects != null){
            for (Object o : objects){
                print(o);
                print(" ");
            }
            println("");
        }
    }

    public static void printListNode(ListNode head){
        if (head == null){
            return;
        }
        System.out.print("List: ");
        while (head != null){
            if (head.next != null){
                System.out.print(head.value + " -> ");
            }else {
                System.out.print(head.value);
            }
            head = head.next;
        }
        System.out.println(" ;");
    }

}
