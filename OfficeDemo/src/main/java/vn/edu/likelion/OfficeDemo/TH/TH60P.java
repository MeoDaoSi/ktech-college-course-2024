package vn.edu.likelion.OfficeDemo.TH;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class TH60P {
    public static void writeFileExcel(BufferedReader data){

        String s;
        int count = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1"); // tao sheet

        try{
            while( (s = data.readLine()) != null ){
                // cat chuoi thanh mang
                if(s.split("\t+",3)[2].equals("1")){
                    Row row = sheet.createRow(count); // tao row i
                    count++;

                    // ghi chuoi vao tung cell
                    for( int indexCell = 0 ; indexCell < 3 ; indexCell++){
                        Cell cell = row.createCell(indexCell);
                        cell.setCellValue(
                                Base64.getEncoder().encodeToString(s.split("\t+",3)[indexCell].getBytes())
                        );
                    }
                }
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            // luu vao file vat ly
            FileOutputStream destFile = new FileOutputStream(
                    "StudentsList_" + LocalDate.now().format(formatter) + ".xlsx"
            );
            workbook.write(destFile);
        }catch (IOException io){
            io.fillInStackTrace();
        }finally {
            try{
                workbook.close();
            }catch (IOException io1){
                io1.fillInStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader docxFile = new BufferedReader(new FileReader("StudentsList.txt"));
        writeFileExcel(docxFile);
    }
}
