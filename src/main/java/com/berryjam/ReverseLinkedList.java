package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/8
 * @time 上午11:45
 */
public class ReverseLinkedList {
    ListNode tail;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            } else {
                return pre;
            }
        }

        return null;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }


        ListNode nextNode = reverse(node.next);
        if (nextNode != null) {
            nextNode.next = node;
        } else {
            this.tail = node;
        }

        return node;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(3);
        ListNode i3 = new ListNode(5);
        ListNode i4 = new ListNode(9);
        ListNode i5 = new ListNode(-1);
        i1.next = i2;
        i2.next = i3;
        i3.next = i4;
        i4.next = i5;
        ListNode result = reverseLinkedList.reverseList(i1);
        int a = 1;
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

}
