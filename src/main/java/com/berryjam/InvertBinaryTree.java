package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/26
 * @time 下午9:54
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            if (root.left == null && root.right == null) {
                return root;
            } else {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                invertTree(root.left);
                invertTree(root.right);
                return root;
            }
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
        System.out.println(tree.invertTree(new TreeNode(2)));
    }
}
