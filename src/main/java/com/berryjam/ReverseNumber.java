package com.berryjam;

/**
 * 递归求一个整数的逆序字符串
 *
 * @author huangjinkun.
 * @date 16/8/7
 * @time 下午1:27
 */
public class ReverseNumber {

    public static String reverseNumber(int number) {
        if (number < 10) {
            return String.valueOf(number);
        } else {
            int remainder = number % 10;
            number = number / 10;
            return String.valueOf(remainder) + reverseNumber(number);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(123478965));
    }
}
