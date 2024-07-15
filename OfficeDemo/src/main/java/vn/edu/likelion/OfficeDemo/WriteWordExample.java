package vn.edu.likelion.OfficeDemo;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteWordExample {
    public static void main(String[] args) {
        // tạo 1 file word
        XWPFDocument document = new XWPFDocument();
        // tạo 1 đoạn văn bản
        XWPFParagraph paragraph = document.createParagraph();
        // tao cau van
        XWPFRun run = paragraph.createRun();
        run.setText("Van Ban Dau Tien\n");
        run.setText("Duoc viet bang java");

        try{
            FileOutputStream fos = new FileOutputStream("output.docx");
            document.write(fos);
            System.out.println("Write file successfully!");
            document.close();
        }catch(IOException io){
            io.fillInStackTrace();
        }

    }
}
