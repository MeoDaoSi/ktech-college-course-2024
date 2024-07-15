package vn.edu.likelion.OfficeDemo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class WritePDFExample {
    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        // tao 1 trang tu doi tuong PDF tren
        PDPage page = new PDPage();
        // lop cho phep ve van ban
        PDPageContentStream content = new PDPageContentStream(document,page);
        // set font va fontsize cho noi dung
//        content.setFont(PDType1Font.HELVETICA_BOLD, 12);

        content.beginText();

        System.out.println(page.getBleedBox());
        content.newLineAtOffset(20,772);
        content.showText("Day la file PDF dau tien");

        content.endText();

        File file = new File("FirstFile.pdf");

    }
}
