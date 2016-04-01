package com.berryjam;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author huangjinkun.
 * @date 16/4/1
 * @time 上午10:06
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;

        while (cur != null) {
            stack.push(cur);
            cur = cur.left;

        }

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if (tmp.right != null) {
                cur = tmp.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        System.out.println(traversal.inorderTraversal(node1));
    }
}
