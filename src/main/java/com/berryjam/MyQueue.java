package com.berryjam;

import java.util.Stack;

/**
 * @author huangjinkun.
 * @date 16/4/30
 * @time 下午8:04
 */
public class MyQueue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();


    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!empty()) {
            if (stack2.size() > 0) {
                stack2.pop();
            } else {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                stack2.pop();
            }
        }
    }

    // Get the front element.
    public int peek() {
        if (!empty()) {
            if (stack2.size() > 0) {
                return stack2.peek();
            } else {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }
        } else {
            return -1;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.size() + stack2.size() == 0 ? true : false;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.empty());
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.empty());
//        myQueue.push(1);
//        myQueue.pop();
//        System.out.println(myQueue.empty());
    }
}
