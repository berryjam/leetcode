package com.berryjam;

// 重点复习，stack overflow，用动态规划

/**
 * @author huangjinkun.
 * @date 16/3/25
 * @time 上午11:53
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
            return false;
        int reach = 0;
        for (int i = 0; i <= reach && i < A.length; i++) {
            reach = Math.max(A[i] + i, reach);
        }
        if (reach < A.length - 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        System.out.println(game.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(game.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
