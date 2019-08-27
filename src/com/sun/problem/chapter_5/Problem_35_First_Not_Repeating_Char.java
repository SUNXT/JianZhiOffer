package com.sun.problem.chapter_5;

import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

import java.util.HashMap;

/**
 * 在字符串中找出第一次只出现一次的字符
 * 例如：'abaadf' 输出 'b'
 */
public class Problem_35_First_Not_Repeating_Char {

    private static Logger logger = LoggerFactory.getLogger(Problem_35_First_Not_Repeating_Char.class);

    public static void main(String[] args){
        String string = "abdshasudbaasdbusdad";
        logger.println(solution(string));
    }

    /**
     * 使用HashMap协助，实现时间复杂度为O(n)
     * HashMap<char,int>
     * 遍历两次
     * 第一次，统计字符出现的个数
     * 遍历第二次，查出第一个次数为1的字符
     * @param str
     * @return
     */
    public static char solution(String str){
        if (str == null || "".equals(str)){
            return '0';
        }
        Character result = str.charAt(0);
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++ i){
            Integer count = map.get(str.charAt(i));
            if (count == null){
                count = 0;
            }
            map.put(str.charAt(i), count + 1);
        }
        for (int i = 0; i < str.length(); ++ i){
            Integer count = map.get(str.charAt(i));
            if (count == 1){
                result = str.charAt(i);
                break;
            }
        }
        return result;
    }
}
