package trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // if a to z
        isEndOfWord = false;
    }
}
