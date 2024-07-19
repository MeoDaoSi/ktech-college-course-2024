package vn.edu.likelion.ConnectDB.services;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class FileTxt {
    private String name;
    private BufferedReader reader = null;

    public FileTxt(String name) throws FileNotFoundException{
        reader = new BufferedReader(new FileReader(name));
    }

    public void closeFile() throws IOException{
        reader.close();
    }

    public BufferedReader getReader() {
        return reader;
    }
}
