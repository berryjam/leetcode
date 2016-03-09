package com.berryjam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjinkun.
 * @date 16/3/9
 * @time 上午11:32
 */
public class BinaryTreePaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();

        if (root != null) {
            result = getBinaryTreePathsByNode(root);
        }

        return result;
    }

    private List<String> getBinaryTreePathsByNode(TreeNode node) {
        List<String> result = new ArrayList<String>();
        String prefix = String.valueOf(node.val);
        if (node.left != null) {
            List<String> leftPostfix = getBinaryTreePathsByNode(node.left);
            for (String s : leftPostfix) {
                result.add(prefix + "->" + s);
            }
        }
        if (node.right != null) {
            List<String> rightPostfix = getBinaryTreePathsByNode(node.right);
            for (String s : rightPostfix) {
                result.add(prefix + "->" + s);
            }
        }
        if (node.left == null && node.right == null) {
            result.add(prefix);
        }
        return result;
    }


    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
