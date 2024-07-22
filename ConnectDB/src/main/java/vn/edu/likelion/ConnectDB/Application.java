package vn.edu.likelion.ConnectDB;

import vn.edu.likelion.ConnectDB.database.Connect;
import vn.edu.likelion.ConnectDB.model.Permission;
import vn.edu.likelion.ConnectDB.model.Student;
import vn.edu.likelion.ConnectDB.model.User;

import java.sql.*;
import java.util.Scanner;

public class Application {

    public static Scanner sc = new Scanner(System.in);

    public static void showOperation(String[] arr){
        for ( int i=0 ; i<3 ; i++ ){
            if( arr[i] == null ){
                continue;
            }
            String operation = arr[i];
            switch (operation){
                case "1": {
                    System.out.println("1. Show Student List");
                    break;
                }
                case "2": {
                    System.out.println("2. Show Student Attendance List");
                    break;
                }
                case "3": {
                    System.out.println("3. Take Attendance");
                    break;
                }
                default: {
                    // do nothing
                }
            }
        }
    };

    public static void main(String[] args) {

        String[] arr = new String[4];
        String[] permission;

        User userService = new User();
        Permission permissionService = new Permission();
        Student studentService = new Student();

        // tao doi tuong Connect
        Connect connect = new Connect();
        // connect db
        connect.openConnect();

        while(true){

            if(arr[0] == null){

                System.out.println("Please login");
                System.out.println("Username:");
                String username = sc.nextLine();
                System.out.println("Password:");
                String password = sc.nextLine();

                try{
                    arr = userService.findUser(connect,username,password);
                    if(arr[0] == null){
                        break;
                    }
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            System.out.println("Welcome " + arr[1] + " to Homepage");
            System.out.println("Please choose operation: ");
            permission = permissionService.getPermission(connect,arr[3]);
            showOperation(permission);

            int operation1 = sc.nextInt();

            if(!permissionService.checkPermission(permission,Integer.toString(operation1))){
                System.out.println("Operation Denied. Access Denied !!!");
                continue;
            }

            switch (operation1){
                case 1: {
                    studentService.getStudent(connect);
                    break;
                }
                case 2: {
                    studentService.getStudentAttendanceList(connect);
                    break;
                }
                case 3: {
                    studentService.takeAttendance(connect,arr[0]);
                    break;
                }
                default: {
                    break;
                }
            }
        }

        connect.closeConnect();
    }
}
