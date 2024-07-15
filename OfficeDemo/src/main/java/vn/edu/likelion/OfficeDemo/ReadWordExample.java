package vn.edu.likelion.OfficeDemo;

import java.io.FileReader;
import java.io.IOException;

public class ReadWordExample {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("output.docx");
        }catch (IOException io){
            io.fillInStackTrace();
        }

    }
}
