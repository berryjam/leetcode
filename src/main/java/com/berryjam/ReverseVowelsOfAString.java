package com.berryjam;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangjinkun.
 * @date 16/5/5
 * @time 下午1:10
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0 || s.equals("")) {
            return "";
        }

        char[] charArray = s.toCharArray();

        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l <= r && !set.contains(charArray[l])) {
                l++;
            }

            while (l <= r && !set.contains(charArray[r])) {
                r--;
            }

            if (l <= r) {
                char tmp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = tmp;
                l++;
                r--;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString app = new ReverseVowelsOfAString();
        System.out.println(app.reverseVowels(""));
    }
}
