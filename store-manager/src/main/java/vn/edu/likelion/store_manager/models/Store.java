package vn.edu.likelion.store_manager.models;

import vn.edu.likelion.store_manager.db.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Store {
    private int id;
    private String name;
    private int user_id;

    // Constructor
    public Store(){

    }
    public Store(int id, String name, int user_id){
        this.id = id;
        this.name = name;
        this.user_id = user_id;
    }
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
    // ----- Setter -----
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    // ----- Setter -----
}
