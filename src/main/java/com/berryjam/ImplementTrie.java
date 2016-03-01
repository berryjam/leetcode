package com.berryjam;


// 重点复习回顾

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // Initialize your data structure here.
    char c;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}


class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }
}


/**
 * @author huangjinkun.
 * @date 16/3/1
 * @time 下午3:17
 */
public class ImplementTrie {

    public static void main(String[] args) {
        // Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
        trie.insert("somestring");
        trie.insert("slic");
//        System.out.println(trie.search("key"));
    }
}
