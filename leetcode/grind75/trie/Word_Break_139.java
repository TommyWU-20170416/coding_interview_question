package trie;

import java.util.Arrays;
import java.util.List;

/**
 * 139.https://leetcode.com/problems/word-break/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/09 16:42:44
 * @since JDK8.0
 * <p>
 * 這題正確來講是
 * 每個 wordDict 內的字都有被使用到
 * wordDict = ["car", "ca", "rs"]
 * s = "cars"
 * 第一次切 car 會剩下 s 覺得 return false
 * 但第二次切 ca rs 就會使用到 s 所以最終回傳 true
 * <p>
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * s = "catsandog";
 * 這題第一次切 cats > and  > 沒有 og
 * 第二次切    cat  > sand > 沒有 og
 * 因為切不出  cats > an   > dog
 * 或是       cat  > san  > dog
 * 最後面都無法切到 dog 所以 return false
 * <p>
 * 如果 s = "catsanddog"; 就 return true
 */
public class Word_Break_139 {
    /**
     * Runtime: 1 ms, Beats 98.79%
     * 滿有趣的一題
     * 但要先了解題目意思，再來是使用 trie ，把 wordDict 放進去
     * 在使用 DP 紀錄 每個單詞都有被找到
     * <p>
     * 如果有重疊，例如 catsand 會被解讀兩次 cat + sand，以及 cats + and
     * DP[i] = s[0 ... i -1] 是否可被分割
     * DP[3] = s[0 ~ 2] 可以被分割 也就是 cat 是可被分割的
     */
    public static void main(String[] args) {
        Word_Break_139 ss = new Word_Break_139();
        Word_Break_139.Solution solution = ss.new Solution();
        String s = "cars";
        String[] wordDict = {"car", "ca", "rs"};
//        String s = "catsandog";
//        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
//        String s = "leetcode";
//        String[] wordDict = {"leet", "code"};
        List<String> l = Arrays.asList(wordDict);
        boolean result = solution.wordBreak(s, l);
        System.out.print(result);
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Trie trie = new Trie();
            for (String word : wordDict) {
                trie.insert(word);
            }

            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
//            for (int i = 1; i <= s.length(); i++) {
//                if (!dp[i]) continue;
//                TrieNode node = trie.getRoot();
//
//                for (int j = i; j <= s.length(); j++) {
//                    char c = s.charAt(j - 1);
//                    node = node.children[c - 'a'];
//                    if (node == null) break;
//                    if (node.isEndOfWord) dp[i] = true;
//                }
//            }
            for (int i = 0; i < s.length(); i++) {
                if (!dp[i]) continue;
                TrieNode node = trie.getRoot();

                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    node = node.children[c - 'a'];
                    if (node == null) break;
                    if (node.isEndOfWord) dp[j + 1] = true;
                }
            }
            return dp[s.length()];
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isEndOfWord = true;
        }

        public boolean searchPrefix(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.isEndOfWord;
        }

        public TrieNode getRoot() {
            return root;
        }
    }
}
