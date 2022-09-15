package sample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement {

    public static void insert(Trie trie1, String word, String meaning) {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }
        word = word.toLowerCase();
        Trie.TrieNode current = trie1.root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index] == null) {
                Trie.TrieNode node = new Trie.TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.endOfWord = true;
        current.meaning = meaning;
    }

    public static void insertFromFile(Trie trie1) throws IOException { //Load các cặp từ từ file .txt vào mảng các Word

        File filename = new File("D:/java/Dictionary/Dictionary_v3/src/sample/dictionaries1.txt");
        Scanner sc = new Scanner(filename);
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            int indexOfTab = currentLine.indexOf("\t");
            String target = currentLine.substring(0, indexOfTab);
            String explain = currentLine.substring(indexOfTab + 1, currentLine.length());
            insert(trie1, target, explain);
        }
        sc.close();
    }

    public static void getWordMeaning(Trie trie1, String word) {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid or empty string");
        }
        word = word.toLowerCase();
        Trie.TrieNode current = trie1.root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                System.out.println("không có từ nầy trong từ điển");
            } else {
                current = current.children[index];
            }
        }
        System.out.println("Nghĩa của từ " + word + " là : " + current.meaning);
    }
    public static void showWord( Trie.TrieNode node, String word) {
        Trie.TrieNode current = node;
        for(int i = 0; i < word.length(); i ++) {
            int index = word.charAt(i) - 'a';
            current = current.children[index];
        }
        display(current,word);
    }

    public static void display(Trie.TrieNode node, String about) {
        Trie.TrieNode current = node;
        if (current != null) {
            if (current.endOfWord == true) {
                System.out.println(about + "    " + current.meaning);
            }
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    display(current.children[i], about + ((char)(i + 97)));
                }
            }
        }
    }
}
