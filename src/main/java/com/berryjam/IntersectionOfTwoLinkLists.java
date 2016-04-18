package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/4/17
 * @time 下午5:48
 */
public class IntersectionOfTwoLinkLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }


        ListNode tmpA = headA;
        ListNode tmpB = headB;
        ListNode longNode, shortNode;

        int longLength, shortLength, m = 0, n = 0;

        for (; tmpA != null; ) {
            m++;
            tmpA = tmpA.next;
        }

        for (; tmpB != null; ) {
            n++;
            tmpB = tmpB.next;
        }

        if (m > n) {
            longLength = m;
            shortLength = n;
            longNode = headA;
            shortNode = headB;
        } else {
            longLength = n;
            shortLength = m;
            longNode = headB;
            shortNode = headA;
        }

        int gap = longLength - shortLength;

        for (int i = 0; i < gap; i++) {
            longNode = longNode.next;
        }

        for (; longNode != null && shortNode != null; ) {
            if (longNode == shortNode) {
                return longNode;
            } else {
                longNode = longNode.next;
                shortNode = shortNode.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkLists app = new IntersectionOfTwoLinkLists();
        ListNode headA = new ListNode(1);
        ListNode A2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode headB = new ListNode(-1);
        ListNode B2 = new ListNode(-2);
        ListNode B3 = new ListNode(-3);

        headA.next = A2;
        A2.next = node3;
        headB.next = B2;
        B2.next = B3;
        B3.next = node3;
        node3.next = node4;
        node4.next = node5;


        System.out.println(app.getIntersectionNode(headA, headB));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}