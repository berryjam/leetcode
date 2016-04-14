package com.berryjam.alibaba;

import java.util.Stack;

/**
 * @author huangjinkun.
 * @date 16/4/15
 * @time 上午12:21
 */
public class Alibaba2015Ext3 {
    int minVal;
    int maxVal;

    public int getMaxAbsoluteValInTree(TreeNode root) {
        if (root == null || root.leftNode == null && root.rightNode == null) {
            return 0;
        }

        minVal = root.val;
        maxVal = root.val;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            minVal = Math.min(minVal, curNode.val);
            maxVal = Math.max(maxVal, curNode.val);
            if (curNode.rightNode != null) {
                stack.push(curNode.rightNode);
            }
            if (curNode.leftNode != null) {
                stack.push(curNode.leftNode);
            }
        }

        return maxVal - minVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.leftNode = node1;
        root.rightNode = node2;
        Alibaba2015Ext3 app = new Alibaba2015Ext3();
        System.out.println(app.getMaxAbsoluteValInTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(int val) {
        this.val = val;
    }


}
