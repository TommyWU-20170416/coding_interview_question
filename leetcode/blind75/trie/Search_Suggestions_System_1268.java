package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268.https://leetcode.com/problems/search-suggestions-system/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/02 16:48:58
 * @since JDK8.0
 */
public class Search_Suggestions_System_1268 {
    public static void main(String[] args) {
        Search_Suggestions_System_1268 s = new Search_Suggestions_System_1268();
        Search_Suggestions_System_1268.Solution solution = s.new Solution();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "abc";
        List<List<String>> result = solution.suggestedProducts(products, searchWord);

        System.out.println(result);

        /**
         * m: ["mobile","moneypot","monitor"]
         * mo: ["mobile","moneypot","monitor"]
         * mou: ["mouse","mousepad"]
         * mous: ["mouse","mousepad"]
         * mouse: ["mouse","mousepad"]
         */
    }

    /**
     * test1
     * 解法:
     * 先把所有的資料 insert 進去，再接著從 searchWord 從 0 ~ i+1 開始查找 prefix
     * 困難的點在需要使用 DFS 的方式去找出至多三個答案
     */
//    class Solution {
//
//        private TrieNode root = new TrieNode();
//
//        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//            for (String product : products) {
//                insert(product);
//            }
//
//            List<List<String>> result = new ArrayList<>();
//            TrieNode node = root;
//
//            for (int i = 0; i < searchWord.length(); i++) {
//                char c = searchWord.charAt(i);
//                List<String> list = new ArrayList<>();
//                if (node != null) {
//                    node = node.children[c - 'a'];
//                }
//                // 如果 node.children[c - 'a'] == null ，會讓 node = null，所以要多判斷有值才繼續 DFS
//                if (node != null) {
//                    dfs(node, searchWord.substring(0, i + 1), list);
//                }
//                result.add(list);
//            }
//
//            return result;
//        }
//
//        // 第一次 帶 m 進去
//        // m 在 for 找到 o 是下一個 != null
//        // mo 在 for 找到 b 是下一個 != null
//        // mob 在 for 找到 i 是下一個 != null
//        // mobi 在 for 找到 l 是下一個 != null
//        // mobil 在 for 找到 e 是下一個 != null
//        // 找到了 mobile，雖然 isEndOfWord 已經 true ，但也要繼續往後找，因為如果有 mobiles 才會找得到
//        // 跑完了 mobile   後面也都沒有，就會返回上一層的 mobil   從 e 往後繼續找，沒找到返回上一層
//        // 跑完了 mobil    後面也都沒有，就會返回上一層的 mobi    從 l 往後繼續找，沒找到返回上一層
//        // 跑完了 mobi     後面也都沒有，就會返回上一層的 mob     從 i 往後繼續找，沒找到返回上一層
//        // 跑完了 mob      後面也都沒有，就會返回上一層的 mo      從 b 往後繼續找，找到了 n
//        // 從 mon 再繼續往後找，依此類推，集滿三個就跳出 dfs
//
//        /**
//         * dfs 又來做深度查找，當 list 集滿 三個 or 全部找完都沒有就返回
//         */
//        private void dfs(TrieNode node, String str, List<String> list) {
//            if (list.size() == 3) return;
//
//            if (node.isEndOfWord) {
//                list.add(str);
//                // return; 想一下為什麼這裡不能放 return
//            }
//            for (char c = 'a'; c <= 'z'; c++) {
//                if (node.children[c - 'a'] != null) {
//                    dfs(node.children[c - 'a'], str + c, list);
//                }
//            }
//        }
//
//        private void insert(String product) {
//            TrieNode node = root;
//            for (char c : product.toCharArray()) {
//                if (node.children[c - 'a'] == null) {
//                    node.children[c - 'a'] = new TrieNode();
//                }
//                node = node.children[c - 'a'];
//            }
//            node.isEndOfWord = true;
//        }
//    }

//    class TrieNode {
//        TrieNode[] children;
//        boolean isEndOfWord;
//
//        public TrieNode() {
//            children = new TrieNode[26]; // if a to z
//            isEndOfWord = false;
//        }
//    }


    /**
     * test2
     * 解法:
     * 由於 每次都用 DFS 下去找太浪費時間，因此需要一個東西去紀錄至多三個匹配的清單
     * 在 TrieNode 內新增 suggestions 紀錄每個節點對應的單字
     * m    對應 0 = "mobile"、1 = "moneypot"、2 = "monitor"
     * mou  對應 0 = "mouse"、1 = "mousepad"
     * <p>
     * 在 prefixSearch 的時候不用記得 每個 substr，因為他是從頭開始下去匹配，每一次匹配都挑出該 node 的 suggestions 最後也會完整找到對應的
     */
    class Solution {

        private TrieNode root = new TrieNode();

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products); // 對產品按字典順序排序
            for (String product : products) {
                insert(product); // 插入每個產品到字典樹中
            }

            List<List<String>> result = new ArrayList<>();
            TrieNode node = root;

            for (int i = 0; i < searchWord.length(); i++) {
                char c = searchWord.charAt(i);
                if (node != null) {
                    node = node.children[c - 'a']; // 遍歷字典樹的子節點
                }
                if (node == null) {
                    result.add(new ArrayList<>()); // 如果節點不存在，返回空列表
                } else {
                    result.add(node.suggestions); // 返回當前節點的建議列表
                }
            }

            return result;
        }

        /**
         * 在 insert 全部跑完後會長這樣，每一個節點都會儲存匹配的前三個單字
         * root
         * - m
         * - suggestions
         * --- 0 = "mobile"
         * --- 1 = "moneypot"
         * --- 2 = "monitor"
         * - children: o
         * --- o
         * ----- suggestions
         * ------- 0 = "mobile"
         * ------- 1 = "moneypot"
         * ------- 2 = "monitor"
         */
        private void insert(String product) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                addSuggestion(node.suggestions, product); // 更新建議列表
            }
            node.isEndOfWord = true;
        }

        private void addSuggestion(List<String> suggestions, String product) {
            if (suggestions.size() < 3) {
                suggestions.add(product); // 當列表小於三個產品時，添加產品
            }
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        List<String> suggestions;

        public TrieNode() {
            children = new TrieNode[26]; // a to z
            isEndOfWord = false;
            suggestions = new ArrayList<>();
        }
    }
}
