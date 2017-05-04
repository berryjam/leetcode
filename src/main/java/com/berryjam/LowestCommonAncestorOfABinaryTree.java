package com.berryjam;

/**
 * @author huangjinkun.
 * @date 2017/4/22
 * @time 下午1:30
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isAncestor(root, p) && isAncestor(root, q)) {
            TreeNode leftCommonAncestor = null;
            if (root.left != null) {
                leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
            }
            TreeNode rightCommonAncestor = null;
            if (root.right != null) {
                rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
            }
            if (leftCommonAncestor == null && rightCommonAncestor == null) {
                return root;
            } else {
                if (leftCommonAncestor != null) {
                    return leftCommonAncestor;
                } else {
                    return rightCommonAncestor;
                }
            }
        } else {
            return null;
        }
    }

    private boolean isAncestor(TreeNode root, TreeNode node) {
        if (root == node) {
            return true;
        }
        boolean leftRes = false;
        if (root.left != null) {
            if (root.left == node) {
                return true;
            } else {
                leftRes = isAncestor(root.left, node);
            }
        }
        boolean rightRes = false;
        if (root.right != null) {
            if (root.right == node) {
                return true;
            } else {
                rightRes = isAncestor(root.right, node);
            }
        }
        return leftRes || rightRes;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree app = new LowestCommonAncestorOfABinaryTree();
        TreeNode threeNode = new TreeNode(3);
        TreeNode fiveNode = new TreeNode(5);
        TreeNode oneNode = new TreeNode(1);
        TreeNode sixNode = new TreeNode(6);
        TreeNode twoNode = new TreeNode(2);
        TreeNode zeroNode = new TreeNode(0);
        TreeNode eightNode = new TreeNode(8);
        TreeNode sevenNode = new TreeNode(7);
        TreeNode fourNode = new TreeNode(4);

        threeNode.left = fiveNode;
        threeNode.right = oneNode;
        fiveNode.left = sixNode;
        fiveNode.right = twoNode;
        oneNode.left = zeroNode;
        oneNode.right = eightNode;
        twoNode.left = sevenNode;
        twoNode.right = fourNode;

        TreeNode res = app.lowestCommonAncestor(threeNode, sixNode, fourNode);
        System.out.println(res.val);
    }
}
