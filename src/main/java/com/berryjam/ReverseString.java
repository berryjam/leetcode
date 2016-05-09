package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/5/9
 * @time 下午4:12
 */
public class ReverseString {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] array = s.toCharArray();
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            char tmp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = tmp;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        ReverseString app = new ReverseString();
        System.out.println(app.reverseString("hello"));
        System.out.println(app.reverseString("helloo"));
    }
}
