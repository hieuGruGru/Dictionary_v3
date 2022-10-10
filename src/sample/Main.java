package sample;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, SQLException {
        DictionaryManagement.insertFromFile("D:\\java\\Dictionary\\Dictionary_v3\\src\\data\\15w.txt");
        DictionaryManagement.insert("wibuu", "đáyyyy");
        DictionaryManagement.insert("amen", "nạy chúa");
        DictionaryManagement.insert("calingchi", "khúm núm");
        DictionaryManagement.exportToFile();
        for (int i = 0; i < DictionaryManagement.dictionary1.list1.size(); i ++) {
            System.out.println(DictionaryManagement.dictionary1.list1.get(i) + "    " + DictionaryManagement.dictionary1.list3.get(i));
        }

    }
}
