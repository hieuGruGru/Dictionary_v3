package sample;

public class Trie {

    public static class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        String meaning;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfWord = false;
            this.meaning = "";
            for(int i= 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

}