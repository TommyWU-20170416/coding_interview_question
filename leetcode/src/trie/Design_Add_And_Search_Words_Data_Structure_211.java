package trie;

/**
 * 211.https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/02 14:43:38
 * @since JDK8.0
 */
public class Design_Add_And_Search_Words_Data_Structure_211 {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // if a to z
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Design_Add_And_Search_Words_Data_Structure_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                // 前面會先看是否 node.children[i] 有值
                // 這邊帶 node.children[i] 是因為要接續往後找 每個 i 有沒有該值
                if (node.children[i] != null && searchHelper(word, node.children[i], index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.children[c - 'a'] == null) return false;
            // 這邊帶 node.children[c - 'a'] 是因為他有找到，所以要用這個繼續往後找
            return searchHelper(word, node.children[c - 'a'], index + 1);
        }
    }

    public static void main(String[] args) {
        Design_Add_And_Search_Words_Data_Structure_211 d = new Design_Add_And_Search_Words_Data_Structure_211();
//        d.addWord("bad");
//        d.addWord("dad");
//        d.addWord("mad");
//        boolean a = d.search("pad");
//        boolean b = d.search("bad");
//        boolean c = d.search(".ad");
//        boolean e = d.search("b..");
        d.addWord("a");
        d.addWord("a");
        boolean a = d.search(".");
        boolean aa = d.search("a");
        boolean aaa = d.search("aa");
        boolean aaaa = d.search("a");
        boolean aaaaa = d.search(".a");
        boolean aaaaaa = d.search("a.");

    }
}
