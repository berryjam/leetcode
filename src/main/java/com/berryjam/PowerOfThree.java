package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/1
 * @time 下午1:52
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        while (n > 1) {
            int shang = n / 3;
            int yushu = n - n / 3 * 3;
            if (yushu != 0) {
                return false;
            }
            if (shang == 1) {
                return true;
            } else {
                n = shang;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PowerOfThree three = new PowerOfThree();
        System.out.println(three.isPowerOfThree(27));
    }
}
