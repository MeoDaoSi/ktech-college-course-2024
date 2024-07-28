package vn.edu.likelion.store_manager.models;

import vn.edu.likelion.store_manager.db.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Store {
    private int id;
    private String name;
    private int user_id;

    // ----- Getter -----
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getUser_id(){
        return user_id;
    }
    // ----- Getter -----
}
