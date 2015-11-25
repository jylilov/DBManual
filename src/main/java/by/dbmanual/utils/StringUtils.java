package by.dbmanual.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class StringUtils {
    public static String stringFromInputStream(InputStream inputStream) {
        String answer = "";
        Reader reader = new InputStreamReader(inputStream);
        try {
            while (reader.ready()) {
                answer += (char)reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
