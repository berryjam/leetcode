package com.berryjam;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * @author huangjinkun.
 * @date 16/2/26
 * @time 下午9:39
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }
        }
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        System.out.println(tree.maxDepth(null));
        System.out.println(tree.maxDepth(new TreeNode(2)));
    }
}
