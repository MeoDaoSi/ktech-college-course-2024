package vn.edu.likelion.ConnectDB.model;

import vn.edu.likelion.ConnectDB.database.Connect;
import vn.edu.likelion.ConnectDB.services.StudentServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Student implements StudentServices {
    public static Scanner sc = new Scanner(System.in);
    @Override
    public void getStudent(Connect connect){
        try{
            String query = "select * from z_student";
            PreparedStatement statement = connect.getConnect().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.print("ID: " + rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\n");
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public void takeAttendance(Connect connect, String user_id) {
        String query1 = "insert into z_attendance_tracker(user_id, student_id, attendance_date, status) values(?,?,?,?)";
        try{
            String query = "select * from z_student";
            PreparedStatement statement = connect.getConnect().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.print("ID: " + rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\n");
                System.out.println("1. Present");
                System.out.println("0. Not Present");
                int check = sc.nextInt();
                PreparedStatement statement1 = connect.getConnect().prepareStatement(query1);
                statement1.setString(2,rs.getString(1));
                statement1.setString(3,LocalDate.now().toString());
                statement1.setInt(4,check);
                statement1.executeQuery();
                System.out.println("\n");
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public void getStudentAttendanceList(Connect connect) {
        String query = "select * from z_attendance_tracker";
        try{
            PreparedStatement statement = connect.getConnect().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString(1) + "\t");
                System.out.print(getNameStudent(connect,rs.getString(2)) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println(" ");
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public String getNameStudent(Connect connect, String id) {
        String query = "select name from z_student where id=? ";
        try{
            PreparedStatement statement = connect.getConnect().prepareStatement(query);
            statement.setString(1,id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getString(1);
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        return "";
    }
}
