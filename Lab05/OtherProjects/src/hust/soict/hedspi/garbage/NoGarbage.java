package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NoGarbage {

    public static void main(String[] args) throws IOException{
        File file = new File("src\\hust\\soict\\hedspi\\garbage\\text.txt");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        String line = "";
        while ((reader.readLine()) != null) {
            sb.append(line) ;
        }
        System.out.println(sb);
        System.out.printf("Processing Time : %d" ,System.currentTimeMillis() - start);
        reader.close();
    }
}