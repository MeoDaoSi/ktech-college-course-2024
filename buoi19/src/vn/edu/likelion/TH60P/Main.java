package vn.edu.likelion.TH60P;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Khai báo các biến
        String sourceFile = "StudentsList.txt"; // Tên file cần đọc
        String destFile; // Tên file cần ghi
        List<String> listStudent = new ArrayList<>(); // Lưu trữ ds Student vào biến tạm listStudent

        // Nhập tên file
        System.out.println("Enter File Name: ");
        Scanner sc = new Scanner(System.in);
        destFile = sc.nextLine();

        Thread deleteFile = new Thread(() -> {
            File myObj = new File(sourceFile);
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        });

        Thread loadFile = new Thread(() -> {

            String line; // Biến tạm để lưu các dòng dữ liệu
            try(
                    BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
                    ){
                // Đọc dữ liệu và gán vào file tạm
                while( (line = reader.readLine()) != null ){
                    listStudent.add(line);
                }
                // Ghi dữ liệu vào file
                for (String s : listStudent) {
                    writer.write(s + " - Odd " + "\n");
                }

            } catch (IOException ex1){
                ex1.fillInStackTrace();
            }
        });
        loadFile.start();
        deleteFile.start();
    }
}
