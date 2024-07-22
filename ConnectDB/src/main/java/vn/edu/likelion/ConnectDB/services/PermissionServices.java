package vn.edu.likelion.ConnectDB.services;

import vn.edu.likelion.ConnectDB.database.Connect;

import java.sql.SQLException;

public interface PermissionServices {
    public String[] getPermission(Connect connect, String id);
    public boolean checkPermission(String[] permission, String operation);
}
