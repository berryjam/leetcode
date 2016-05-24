package com.berryjam;

/**
 * https://www.hrwhisper.me/leetcode-verify-preorder-serialization-of-a-binary-tree/
 *
 * 对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有
 * 1.所有的非空节点提供2个出度和1个入度（根除外）
 * 2.所有的空节点但提供0个出度和1个入度
 * 我们在遍历的时候，计算diff = outdegree – indegree. 当一个节点出现的时候，diff – 1，因为它提供一个入度；当节点不是#的时候，
 * diff+2(提供两个出度) 如果序列式合法的，那么遍历过程中diff >=0 且最后结果为0.
 *
 *
 * @author huangjinkun.
 * @date 16/5/25
 * @time 上午12:03
 */
public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree app = new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(app.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(app.isValidSerialization("1,#"));
        System.out.println(app.isValidSerialization("9,#,#,1"));
        System.out.println(app.isValidSerialization("#"));
    }
}
