package vn.edu.likelion.ConnectDB.services;

import vn.edu.likelion.ConnectDB.database.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface StudentServices {
    public void getStudent(Connect connect);
    public void takeAttendance(Connect connect, String id);
    public void getStudentAttendanceList(Connect connect);
    public String getNameStudent(Connect connect, String id);
}
