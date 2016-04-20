package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/25
 * @time 下午11:59
 */
public class NimGame {

    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NimGame game = new NimGame();
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + ":" + game.canWinNim(i));
        }
    }
}
