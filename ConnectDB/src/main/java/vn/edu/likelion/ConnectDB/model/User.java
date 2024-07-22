package vn.edu.likelion.ConnectDB.model;

import netscape.javascript.JSObject;
import vn.edu.likelion.ConnectDB.database.Connect;
import vn.edu.likelion.ConnectDB.services.UserServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class User implements UserServices {
    @Override
    public void insertUser(Connect connect, int id, String username, String password) throws SQLException {
        String query = "insert into z_users values(?, ?, ?)";
        PreparedStatement userState = connect.getConnect().prepareStatement(query);
        userState.setInt(1,id);
        userState.setString(2, username);
        userState.setString(3, Base64.getEncoder().encodeToString(password.getBytes()));
        userState.executeQuery();
    }

    @Override
    public void selectAllUser(Connect connect) throws SQLException {
        String query = "select * from z_users";
        PreparedStatement userState = connect.getConnect().prepareStatement(query);
        ResultSet result = userState.executeQuery();
    }

    @Override
    public String[] findUser(Connect connect, String username, String password) throws SQLException {
        String query = "select z_users.id, username, password, z_role.id from z_users, z_role " +
                "where z_users.id=z_role.id and username=? and password=?";
        PreparedStatement userState = connect.getConnect().prepareStatement(query);
        userState.setString(1,username);
        userState.setString(2,Base64.getEncoder().encodeToString(password.getBytes()));
        ResultSet resultSet = userState.executeQuery();

        String[] arr = new String[4];

        if (resultSet.next()){
            arr[0] = resultSet.getString(1);
            arr[1] = resultSet.getString(2);
            arr[2] = resultSet.getString(3);
            arr[3] = resultSet.getString(4);
        }else{
            System.out.println("Username or password not founded!");
        }
        return arr;
    }
}
