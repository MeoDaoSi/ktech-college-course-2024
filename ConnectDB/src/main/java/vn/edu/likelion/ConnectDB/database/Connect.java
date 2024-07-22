package vn.edu.likelion.ConnectDB.database;

import java.sql.*;

public class Connect {
    private String url = "jdbc:oracle:thin:@localhost:1522:xe";
    private String username = "system";
    private String password = "Meodaosi";

    private Connection connect = null;

    public void openConnect(){
        try{
            connect = DriverManager.getConnection(url,username,password);
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void closeConnect(){
        try{
            if( connect != null){
                connect.close();
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public Connection getConnect() {
        return connect;
    }
}
