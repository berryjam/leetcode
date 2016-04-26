package com.berryjam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/4/25
 * @time 下午8:31
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0, l = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, i);
            result = Math.max(result, i - l + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(app.lengthOfLongestSubstring("abba"));
        System.out.println(app.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(app.lengthOfLongestSubstring("bbbbb"));
        System.out.println(app.lengthOfLongestSubstring("pwwkew"));
    }
}
