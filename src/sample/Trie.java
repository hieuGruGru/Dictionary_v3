package sample;

public class Trie {

    public static class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        String target;//Từ cần dịch - dùng để show()
        String target_Normalize;//Từ cần dịch, được chuẩn hóa (bỏ dấu, bỏ cách) - dùng để search(), insert()
        String meaning;//Nghĩa của từ cần dịch
        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfWord = false;
            this.target = "";
            this.meaning = "";
            this.target_Normalize = "";
            for(int i= 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
        public String getTarget() {
            return target;
        }
        public String getMeaning() {
            return meaning;
        }
        public String getTarget_Normalize() {
            return target_Normalize;
        }
        public void setTarget(String target) {
            this.target = target;
        }
        public void setTarget_Normalize(String target_Normalize) {
            this.target_Normalize = target_Normalize;
        }
        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }
        public boolean isEndOfWord() {
            return endOfWord;
        }

    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

}