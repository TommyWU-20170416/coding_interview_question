import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "catsanddog";
//        String[] str = {"cat", "cats", "and", "sand", "dog"};
//        String[] str = {"cat", "san", "ddo", "g"};
//        String[] str = {"ca", "ts", "an", "dd", "og"};

        // 驗證字典內重複率高的情境
//        String s = "aaaaaaa";
//        String[] str = {"aaaa", "aa", "a"};

        // 驗證單字被拆成單一詞彙
        String s = "zxcvbnm";
        String[] str = {"z", "x", "c", "v", "b", "n", "m"};

        List<String> wordDict = Arrays.asList(str);
        List<String> result = solution.wordBreak(s, wordDict);
        System.out.print(result);
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // 假設所有字母都是小寫字母
    boolean isEndOfWord;

    // 插入到 Trie
    public void insertTrie(TrieNode root, String word) {
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
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) { /** 插入到 trie: time complexity: O(W) */
            root.insertTrie(root, word);
        }

        // 動態規劃表
        List<String>[] dp = new List[s.length() + 1];
        dp[0] = new ArrayList<>(); // 初始化空字串

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
                    if (dp[j + 1] == null) { // j + 1 是因為 dp 的索引比 s 的索引多 1
                        dp[j + 1] = new ArrayList<>();
                    }
                    String sub = s.substring(i, j + 1); // 把單詞拿出來
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