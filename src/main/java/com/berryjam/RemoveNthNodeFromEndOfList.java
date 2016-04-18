package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/4/18
 * @time 下午4:03
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        ListNode fastNode = null, slowNode = null, preNode = null;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                fastNode = head;
            } else {
                fastNode = fastNode.next;
                if (i != n - 1 && fastNode == null) {
                    return null;
                }
            }
        }

        while (fastNode != null) {
            if (slowNode == null) {
                slowNode = head;
            } else {
                preNode = slowNode;
                slowNode = slowNode.next;
            }
            fastNode = fastNode.next;
        }

        if (preNode == null) {
            head = slowNode.next;
            slowNode.next = null;
            return head;
        } else {
            preNode.next = slowNode.next;
            slowNode.next = null;
        }


        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList app = new RemoveNthNodeFromEndOfList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(app.removeNthFromEnd(node1, 1).val);
    }
}
