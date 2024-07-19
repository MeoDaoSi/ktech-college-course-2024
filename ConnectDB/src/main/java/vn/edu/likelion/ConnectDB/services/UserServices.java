package vn.edu.likelion.ConnectDB.services;

import vn.edu.likelion.ConnectDB.database.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class UserServices {

    public void insertUser(Connect connect, int id, String username, String password) throws SQLException {
        String query = "insert into z_users values(?, ?, ?)";
        PreparedStatement userState = connect.getConnect().prepareStatement(query);
        userState.setInt(1,id);
        userState.setString(2, username);
        userState.setString(3, Base64.getEncoder().encodeToString(password.getBytes()));
        userState.executeQuery();
    }
}
