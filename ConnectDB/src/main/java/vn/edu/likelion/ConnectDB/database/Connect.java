package vn.edu.likelion.ConnectDB.database;

import java.sql.*;

public class Connect {
    private String url = "jdbc:oracle:thin:@localhost:1522:xe";
    private String username = "system";
    private String password = "Meodaosi";

    private Connection connect = null;

    public void openConnect() throws SQLException{
        connect = DriverManager.getConnection(url,username,password);
    }

    public void closeConnect() throws SQLException{
        if( connect != null){
            connect.close();
        }
    }

    public Connection getConnect() {
        return connect;
    }
}
