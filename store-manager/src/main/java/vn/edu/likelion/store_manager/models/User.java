package vn.edu.likelion.store_manager.models;

import vn.edu.likelion.store_manager.db.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;

    // Constructor
    public User(){

    }
    public User(int id, String username, String password, String role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // ----- Getter -----
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    // ----- Getter -----
    // ----- Setter -----
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    // ----- Setter -----
    // ----- Method Login -----
    public User login(
            Connect connect,
            PreparedStatement statement,
            ResultSet rs,
            String username,
            String password
    ) throws SQLException {
        String SQLQuery = "Select * from tb1_users where username=?";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setString(1,username);
        rs = statement.executeQuery();
        if(rs.next()){
            // Encode password user
            String encoder = Base64.getEncoder().encodeToString(password.getBytes());
            // Check password
            if(rs.getString(3).equals(encoder)){
                System.out.println("Login Successfully !");
                return new User(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));
            }else{
                System.out.println("Invalid Password !");
                return null;
            }
        }
        System.out.println("Username Not Founded !");
        return null;
    }
    // ----- Method Add User -----
    public void addUser(
        Connect connect, PreparedStatement statement, ResultSet rs,
        String username, String password
    ) throws SQLException{
        String SQLQuery = "Insert into tb1_users values(?,?,?,?)";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setInt(1,(int)(Math.random()*100));
        statement.setString(2,username);
        statement.setString(3,Base64.getEncoder().encodeToString(password.getBytes()));
        statement.setString(4,"USER");
        statement.executeQuery();
        System.out.println("Add User Success");
    }
    // ----- Method Change Password -----
    public void changePassword(
            Connect connect,
            PreparedStatement statement,
            ResultSet rs,
            String username,
            String newpw
    ) throws SQLException {
        String SQLQuery = "update tb1_users set password=? where username=?";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setString(1,Base64.getEncoder().encodeToString(newpw.getBytes()));
        statement.setString(2,username);
        statement.executeQuery();
        System.out.println("Update Password Success!");
    }
}
