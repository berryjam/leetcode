package com.berryjam;

// 重点复习

/**
 * 完全二叉树
 * 如果从某节点一直向左的高度 = 一直向右的高度, 那么以该节点为root的子树一定是complete binary tree;
 * 如果高度不相等, 则递归调用 return countNode(left) + countNode(right) + 1.  复杂度为O(h^2)
 *
 * @author huangjinkun.
 * @date 16/4/20
 * @time 下午4:35
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int count = 0;

        if (root == null) {
            return count;
        } else {
            int l = getLeft(root) + 1;
            int r = getRight(root) + 1;
            if (l == r) {
                return (2 << (l - 1)) - 1;
            } else {
                return countNodes(root.left) + countNodes(root.right) + 1;
            }
        }
    }

    private int getLeft(TreeNode node) {
        int count = 0;
        while (node.left != null) {
            node = node.left;
            count++;
        }

        return count;
    }

    private int getRight(TreeNode node) {
        int count = 0;
        while (node.right != null) {
            node = node.right;
            count++;
        }

        return count;
    }
}

