package vn.edu.likelion.ConnectDB.services;

import vn.edu.likelion.ConnectDB.database.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public interface UserServices {
    public void insertUser(Connect connect, int id, String username, String password) throws SQLException;
    public void selectAllUser(Connect connect) throws SQLException;
    public String[] findUser(Connect connect, String username, String password) throws SQLException;
}
