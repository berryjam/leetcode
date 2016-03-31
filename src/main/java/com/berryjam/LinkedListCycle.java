package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/31
 * @time 下午10:20
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean back = false;

        while (fast != null) {
            if (fast == slow) {
                if (back) {
                    return true;
                }
            }

            fast = fast.next;
            back = true;
            if (fast == null) {
                return false;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }

        return false;
    }


    public static void main(String[] args) {
        LinkedListCycle cycle = new LinkedListCycle();
        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = two;
        System.out.println(cycle.hasCycle(one));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
