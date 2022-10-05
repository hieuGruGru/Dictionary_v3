package sample;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, SQLException {
        DictionaryManagement.insertFromFile("D:\\java\\Dictionary\\Dictionary_v3\\src\\data\\1900w_V-E.txt");
        Trie.TrieNode newTrie = DictionaryManagement.search("cư");
        DictionaryManagement.showAllWord(newTrie, "");



    }
}
