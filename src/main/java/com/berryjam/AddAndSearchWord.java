package com.berryjam;


import java.util.ArrayList;
import java.util.List;


// 重点复习

/**
 * @author huangjinkun.
 * @date 16/3/1
 * @time 下午2:04
 */
public class AddAndSearchWord {


    public static void main(String[] args) {
        AddAndSearchWord.WordDictionary dictionary = new AddAndSearchWord.WordDictionary();
//        dictionary.addWord("bad");
//        dictionary.addWord("dad");
//        dictionary.addWord("mad");
        dictionary.addWord("a");
        dictionary.addWord("a");
        dictionary.search(".");
        dictionary.search("a");
        dictionary.search("aa");
        dictionary.search("a");
        dictionary.search(".a");
        dictionary.search("a.");
//        System.out.println(dictionary.search("pad"));
//        System.out.println(dictionary.search("bad"));
//        System.out.println(dictionary.search(".ad"));
//        System.out.println(dictionary.search("b.."));
    }


    static class WordDictionary {
        List<String> words = new ArrayList<String>();

        // Adds a word into the data structure.
        public void addWord(String word) {
            words.add(word);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            boolean result = false;
            for (String dicWord : words) {
                if (dicWord.length() != word.length()) {
                    continue;
                }
                for (int i = 0; i < word.length(); i++) {
                    char patternCh = word.charAt(i);
                    char dicCh = dicWord.charAt(i);
                    if (patternCh != '.') {
                        if (patternCh != dicCh) {
                            break;
                        } else {
                            if (i == word.length() - 1) {
                                return true;
                            }
                        }
                    } else {
                        if (i == word.length() - 1) {
                            return true;
                        }
                    }
                }
            }

            return result;
        }


        static class TreeNode{

        }
    }
}