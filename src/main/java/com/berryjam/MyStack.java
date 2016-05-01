package com.berryjam;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangjinkun.
 * @date 16/4/30
 * @time 下午7:56
 */
public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();
    private int peekQueue = 1;


    // Push element x onto stack.
    public void push(int x) {
        if (peekQueue == 1) {
            if (queue1.size() == 0) {
                queue1.offer(x);
            } else {
                while (queue1.size() > 0) {
                    queue2.offer(queue1.poll());
                }
                queue1.offer(x);
            }
        } else {
            if (queue2.size() == 0) {
                queue2.offer(x);
            } else {
                while (queue2.size() > 0) {
                    queue1.offer(queue2.poll());
                }
                queue2.offer(x);
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!empty()) {
            if (peekQueue == 1) {
                queue1.poll();
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                peekQueue = 2;
            } else {
                queue2.poll();
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                peekQueue = 1;
            }
        }
    }

    // Get the top element.
    public int top() {
        if (!empty()) {
            if (peekQueue == 1) {
                return queue1.peek();
            } else {
                return queue2.peek();
            }
        } else {
            return -1;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.size() + queue2.size() == 0 ? true : false;
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.empty());
    }
}
