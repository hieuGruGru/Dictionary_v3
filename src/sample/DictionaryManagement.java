package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public static Dictionary dictionary1 = new Dictionary();

    public static void insert(String target, String meaning) throws IllegalAccessException {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }
        String target_n = Normalize.remove(target);
        Trie.TrieNode current = dictionary1.trie.root;
        for (int i = 0; i < target_n.length(); i++) {
            int index = target_n.charAt(i) - 'a';
            if (current.children[index] == null) {
                Trie.TrieNode node = new Trie.TrieNode();
                String temp = current.target_Normalize;
                current.children[index] = node;
                current = node;
                current.setTarget_Normalize(temp + target_n.charAt(i));
            } else {
                current = current.children[index];
            }
        }
        current.meaning = meaning;
        current.endOfWord = true;
        current.target = target;
    }

    public static void insertFromFile(String path) throws IOException, IllegalAccessException { //Load các cặp từ từ file .txt vào mảng các Word
        File filename = new File(path);
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            int indexOfTab = currentLine.indexOf("\t");
            String word = currentLine.substring(0, indexOfTab);
            String meaning = currentLine.substring(indexOfTab + 1, currentLine.length());
            insert(word, meaning);
        }
        sc.close();
    }

    public static Trie.TrieNode search(String word) throws IllegalAccessException {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid or empty string");
        }
        String target_N = Normalize.remove(word);
        Trie.TrieNode current = dictionary1.trie.root;
        for (int i = 0; i < target_N.length(); i++) {
            int index = target_N.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return null;
            }
        }
        return current;
    }

    public static void showAllWord(Trie.TrieNode node, String str) {
        Trie.TrieNode current = node;
        if (current != null) {
            if (current.endOfWord == true) {
                String target = current.target;
                String meaning = current.getMeaning();
                System.out.println(target + "  " + "  " + meaning);
            }
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    showAllWord(current.children[i], str + ((char) (i + 97)));
                }
            }
        }
    }

    public static void exportToFile() throws IOException { //Ghi các từ mới vào file .txt
        File fileOut = new File("D:\\java\\Dictionary\\Dictionary_v3\\src\\data\\17w-export.txt");
        FileWriter fileWriter = new FileWriter(fileOut,true);
        BufferedWriter bWrite = new BufferedWriter(fileWriter);

        loadToList(dictionary1.trie.root, dictionary1.list1, 1);
        loadToList(dictionary1.trie.root, dictionary1.list3, 2);
        for(int i = 0; i < dictionary1.list1.size(); i ++) {
            bWrite.write(dictionary1.list1.get(i) + "\t");
            bWrite.write(dictionary1.list3.get(i) + "\n");
        }
        bWrite.close();
    }

    public static void loadToList(Trie.TrieNode node, ArrayList list, int mode) {
        Trie.TrieNode current = node;
        if (mode == 1) {// Lưu target
            if (current != null) {
                if (current.getEndOfWord()) {
                    list.add(current.getTarget());
                }
                for (int i = 0; i < 26; i++) {
                    if (current.children[i] != null) {
                        loadToList(current.children[i], list, mode);
                    }
                }
            }
        } else {//Lưu meaning
            if (current != null) {
                if (current.getEndOfWord()) {
                    list.add(current.getMeaning());
                }
                for (int i = 0; i < 26; i++) {
                    if (current.children[i] != null) {
                        loadToList(current.children[i], list, 2);
                    }
                }
            }
        }
    }

}
