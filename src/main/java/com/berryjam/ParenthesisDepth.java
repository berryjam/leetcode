package com.berryjam;

import java.util.Stack;

/**
 * @author huangjinkun.
 * @date 16/4/1
 * @time 下午12:16
 */
public class ParenthesisDepth {

    public int parenthesisDepth(String input) {
        if (input == null || input.length() == 0 || !validParenthesis(input)) {
            return -1;
        }
        int depth = 0;

        Stack<Integer> depths = new Stack<Integer>();
        depths.push(0);

        int curDepth = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(':
                    curDepth = depths.peek() + 1;
                    depths.push(curDepth);
                    break;
                case ')':
                    curDepth = depths.pop();
                    depth = Math.max(depth, curDepth);
                    break;
            }
        }

        return depth;
    }

    public boolean validParenthesis(String input) {
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ParenthesisDepth depth = new ParenthesisDepth();
        System.out.println(depth.parenthesisDepth("())"));
        System.out.println(depth.parenthesisDepth("(())"));
        System.out.println(depth.parenthesisDepth("(((x)) (((y))))"));
    }
}
