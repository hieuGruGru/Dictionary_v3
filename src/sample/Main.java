package sample;

import java.io.IOException;

public class Main {
    public static void main(String []args) throws IOException {
        Trie t = new Trie();
        DictionaryManagement.insertFromFile(t);
        DictionaryManagement.showWord(t.root,"s");
        DictionaryManagement.getWordMeaning(t,"soup");
    }
}
