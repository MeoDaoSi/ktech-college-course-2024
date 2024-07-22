package vn.edu.likelion.ConnectDB.model;

import vn.edu.likelion.ConnectDB.database.Connect;
import vn.edu.likelion.ConnectDB.services.PermissionServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Permission implements PermissionServices{
    @Override
    public String[] getPermission(Connect connect, String id){
        String[] arr = new String[3];
        int lastIndex = 0;
        try{
            String query = "select PERMISSION_ID, NAME from z_role_permission, z_permission " +
                    "WHERE z_role_permission.ROLE_ID=? AND Z_ROLE_PERMISSION.PERMISSION_ID=Z_PERMISSION.ID";
            PreparedStatement statement = connect.getConnect().prepareStatement(query);
            statement.setString(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                arr[lastIndex] = rs.getString(1);
                lastIndex++;
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        return arr;
    }

    @Override
    public boolean checkPermission(String[] permission, String operation) {
        for( String e: permission){
            if( e!=null && e.equals(operation)){
                return true;
            }
        }
        return false;
    }
}
