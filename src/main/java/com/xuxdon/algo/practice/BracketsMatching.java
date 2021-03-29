package com.xuxdon.algo.practice;

import java.util.*;

/**
 * 括号匹配的算法实现
 */
public class BracketsMatching {

    /**
     * 用栈和队列分别从头装入要处理的一组数据
     * 弹栈后的数据是逆序的，出队后的数据是原顺序的 (栈的逆序特性)
     * 可以用这一特性进行匹配判断
     */
    public static boolean match(String str){
        int count = 0;
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if ("{}[]()\"".contains(c + "")){
                count++;
                queue.add(str.charAt(i));
                stack.push(str.charAt(i));
            }
        }

        if (count % 2 != 0){
            return false;
        }

        for (int i=0; i<(count / 2); i++){
            char front = queue.poll();
            char back = stack.pop();

            if (front == '{' && back != '}'){ return false; }
            if (front == '[' && back != ']'){ return false; }
            if (front == '(' && back != ')'){ return false; }
            if (front == '"' && back != '"'){ return false; }
        }

        return true;
    }

}
