package vn.edu.likelion.ConnectDB;

import vn.edu.likelion.ConnectDB.database.Connect;
import vn.edu.likelion.ConnectDB.services.FileTxt;
import vn.edu.likelion.ConnectDB.services.UserServices;

import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class Application {
    public static void main(String[] args) {

        String query = "Insert into Z_STUDENT(id, name) VALUES (?, ?)";
        UserServices userServices = new UserServices();

        // doc file txt
        try{
            // tao doi tuong Connect
            Connect connect = new Connect();
            // connect db
            connect.openConnect();

//            FileTxt file = new FileTxt("StudentsList.txt");
//            String line;
//            while((line = file.getReader().readLine()) != null ){
//                // gui cau lenh truy van toi database
//                PreparedStatement state = connect.getConnect().prepareStatement(query);
//                state.setString(1,line.split("\t",3)[0]);
//                state.setString(2,line.split("\t",3)[1]);
//                // thuc hien truy van
//                ResultSet resultSet = state.executeQuery();
//            }

//            userServices.insertUser(connect,1,"freeze1","123456");
//            userServices.insertUser(connect,2,"freeze2","123456");
//            userServices.insertUser(connect,3,"freeze3","123456");
//            userServices.insertUser(connect,4,"freeze4","123456");

//            file.closeFile();
            connect.closeConnect();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
