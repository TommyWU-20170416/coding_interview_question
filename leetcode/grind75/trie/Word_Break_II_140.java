package trie;

import java.util.*;

/**
 * 140.https://leetcode.com/problems/word-break-ii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/09/26 20:50:19
 * @since JDK8.0
 */
public class Word_Break_II_140 {
    public static void main(String[] args) {
        Word_Break_II_140 ss = new Word_Break_II_140();
        Word_Break_II_140.Solution solution = ss.new Solution();
//        String s = "catsanddog";
//        String[] str = {"cat", "cats", "and", "sand", "dog"};
//        String[] str = {"cat", "san", "ddo", "g"};
//        String[] str = {"ca", "ts", "an", "dd", "og"};

//        String s = "aaaaaaa";
//        String[] str = {"aaaa", "aa", "a"};

        String s = "zxcvbnm";
        String[] str = {"z", "x", "c", "v", "b", "n", "m"};

        List<String> wordDict = Arrays.asList(str);
        List<String> result = solution.wordBreak(s, wordDict);
        System.out.print(result);
    }

    /**
     * 使用 trie + dfs
     */
//    class TrieNode {
//        TrieNode[] children;
//        boolean isEndOfWord;
//
//        public TrieNode() {
//            children = new TrieNode[26];
//            isEndOfWord = false;
//        }
//    }
//
//    class Trie {
//        TrieNode root = new TrieNode();
//
//        public void insert(String word) {
//            TrieNode node = root;
//            for (char c : word.toCharArray()) {
//                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
//                node = node.children[c - 'a'];
//            }
//            node.isEndOfWord = true;
//        }
//
//        public boolean search(String word) {
//            TrieNode node = root;
//            for (char c : word.toCharArray()) {
//                if (node.children[c - 'a'] == null) return false;
//                node = node.children[c - 'a'];
//            }
//            return node.isEndOfWord;
//        }
//    }
//    class Solution {
//        public List<String> wordBreak(String s, List<String> wordDict) {
//            Trie trie = new Trie();
//            for (String word : wordDict) {
//                trie.insert(word);
//            }
//            List<String> result = new ArrayList<>();
//            dfs(s, trie, 0, new StringBuilder(), result);
//            return result;
//        }
//
//        private void dfs(String s, Trie trie, int start, StringBuilder current, List<String> result) {
//            if (start == s.length()) {
//                result.add(current.toString().trim());
//                return;
//            }
//
//            for (int end = start + 1; end <= s.length(); end++) {
//                String word = s.substring(start, end);
//                if (trie.search(word)) {
//                    int lengthBefore = current.length();
//                    current.append(word).append(" ");
//                    dfs(s, trie, end, current, result);
//                    current.setLength(lengthBefore);
//                }
//            }
//        }
//    }

    /**
     * 使用 trie + dp
     */
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 假設所有字母都是小寫字母
        boolean isEndOfWord;

        // 插入到 Trie
        private void insertTrie(TrieNode root, String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }
    }

    // 使用 Trie 和動態規劃解決問題
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            int count = 1;
            TrieNode root = new TrieNode();

            for (String word : wordDict) { /** 插入到 trie: time complexity: O(W) */
                root.insertTrie(root, word);
            }

            // 動態規劃表
            List<String>[] dp = new List[s.length() + 1];
            dp[0] = new ArrayList<>(); // 初始化空字串可以被成功分割

            /** 每一次嘗試在 i 位置進行 m 次 trie 匹配: time complexity:O(n * m) */
            for (int i = 0; i < s.length(); i++) { /** 外層: time complexity: O(n) */
                if (dp[i] == null) continue; // 如果不能被分割，跳過
                TrieNode node = root;
                for (int j = i; j < s.length(); j++) { /** 內層取決字典內的單字，假設最長的單詞是 m: time complexity: O(m) */
                    char c = s.charAt(j);
                    int index = c - 'a';
                    if (node.children[index] == null) break; // 字典中無此單詞片段
                    node = node.children[index];
                    if (node.isEndOfWord) {
                        System.out.println("第" + count++ + "次");
                        if (dp[j + 1] == null) { // j + 1 是因為 dp 的索引比 s 的索引多 1
                            dp[j + 1] = new ArrayList<>();
                        }
                        String sub = s.substring(i, j + 1); // 把 單詞拿出來
                        if (i == 0) { // 表示是第一個單詞
                            dp[j + 1].add(sub);
                        } else {
                            for (String str : dp[i]) {
                                dp[j + 1].add(str + " " + sub);
                            }
                        }
                    }
                }
            }

            return dp[s.length()] == null ? new ArrayList<>() : dp[s.length()];
        }
    }
/**
 * 使用 backtrack 的方式
 */
//    class Solution {
//        public List<String> wordBreak(String s, List<String> wordDict) {
//            Set<String> wordSet = new HashSet<>(wordDict);
//            List<String> result = new ArrayList<>();
//            backtrack(s, 0, wordSet, new StringBuilder(), result);
//            return result;
//        }
//
//        private void backtrack(String s, int start, Set<String> wordSet, StringBuilder current, List<String> result) {
//            if (start == s.length()) {
//                result.add(current.toString().trim()); // Add the formed sentence
//                return;
//            }
//
//            for (int end = start + 1; end <= s.length(); end++) {
//                String word = s.substring(start, end);
//                if (wordSet.contains(word)) {
//                    int lengthBefore = current.length();
//                    current.append(word).append(" "); // Add the valid word
//                    backtrack(s, end, wordSet, current, result); // Recur for the next part
//                    current.setLength(lengthBefore); // Backtrack
//                }
//            }
//        }
//    }

    /**
     * 使用 DP
     */
//    class Solution {
//        public List<String> wordBreak(String s, List<String> wordDict) {
//            Set<String> wordSet = new HashSet<>(wordDict);
//            boolean[] dp = new boolean[s.length() + 1];
//            dp[0] = true;
//            for (int i = 1; i <= s.length(); i++) {
//                for (int j = 0; j < i; j++) {
//                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//            List<String> result = new ArrayList<>();
//            // 檢查是否 s 至少可被一個分割
//            if (dp[s.length()]) {
//                backtrack(s, wordSet, dp, s.length(), new LinkedList<>(), result);
//            }
//            return result;
//        }
//
//        private void backtrack(String s, Set<String> wordSet, boolean[] dp, int end, Deque<String> path, List<String> result) {
//            if (end == 0) {
//                result.add(String.join(" ", path));
//                return;
//            }
//            for (int i = end - 1; i >= 0; i--) {
//                String word = s.substring(i, end);
//                if (dp[i] && wordSet.contains(word)) {
//                    path.addFirst(word);
//                    backtrack(s, wordSet, dp, i, path, result);
//                    path.removeFirst();
//                }
//            }
//        }
//    }

}