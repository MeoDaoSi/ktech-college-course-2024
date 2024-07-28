package vn.edu.likelion.store_manager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String url = "jdbc:oracle:thin:@localhost:1522:xe";
    private String username = "system";
    private String password = "Meodaosi";

    private Connection connect = null;

    public Connection getConnect(){
        return connect;
    }

    public void openConnect() throws SQLException {
        connect = DriverManager.getConnection(url,username,password);
    }
    public void closeConnect() throws SQLException {
        if( connect != null ){
            connect.close();
        }
    }
}
