package sample;

public class Main {
    public static void main(String []args) {
        Trie t = new Trie();
        DictionaryManagement.insert(t,"car","bíp bíp");
        DictionaryManagement.insert(t,"cat","mèo méo meo mèo meo");
        DictionaryManagement.insert(t,"care","lớp 1 đến lớp 5");
        DictionaryManagement.insert(t,"dog","inu");
        DictionaryManagement.insert(t,"fish","sakana");
        DictionaryManagement.insert(t,"dont","okaka");


        System.out.println("Insert successful!!");
        DictionaryManagement.search(t,"car");
        DictionaryManagement.display(t.root,"");

    }
}
