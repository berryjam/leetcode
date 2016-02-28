package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/28
 * @time 上午9:45
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }

        if (p != null && q == null || p == null && q != null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        return false;
    }
}
