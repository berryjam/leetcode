package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/31
 * @time 下午11:10
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode resultHead = head.next;

        ListNode preNode1 = null;
        ListNode node1 = head;
        ListNode node2;
        ListNode nextNode1;
        while (node1 != null) {
            node2 = node1.next;
            if (node2 != null) {
                nextNode1 = node2.next;
                swapPairs(preNode1, node1, node2);
                preNode1 = node1;
                node1 = nextNode1;
            } else {
                break;
            }
        }

        return resultHead;
    }

    private void swapPairs(ListNode preNode1, ListNode node1, ListNode node2) {
        if (preNode1 != null) {
            preNode1.next = node2;
            ListNode node2Next = node2.next;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            ListNode node2Next = node2.next;
            node2.next = node1;
            node1.next = node2Next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
