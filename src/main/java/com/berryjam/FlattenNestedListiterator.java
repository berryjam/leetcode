package com.berryjam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangjinkun.
 * @date 16/5/17
 * @time 下午9:03
 */
public class FlattenNestedListiterator {


}

//
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}


class NestedIterator implements Iterator<Integer> {

    int index = -1;
    Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null && nestedList.size() > 0) {
            queue = new LinkedList<Integer>();
            index = 0;
        }
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                queue.offer(nestedInteger.getInteger());
            } else {
                NestedIterator nestedIterator = new NestedIterator(nestedInteger.getList());
                while (nestedIterator.hasNext()) {
                    queue.offer(nestedIterator.next());
                }
            }
        }
    }

    public Integer next() {
        return queue.poll();
    }

    public void remove() {
        if (hasNext()) {
            queue.poll();
        }
    }

    public boolean hasNext() {
        if (queue != null && !queue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */