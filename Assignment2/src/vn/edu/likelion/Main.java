package vn.edu.likelion;

import vn.edu.likelion.model.ClassRoom;
import vn.edu.likelion.model.Student;
import vn.edu.likelion.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);



    public static void main(String[] args){
        List<ClassRoom> school = new ArrayList<>();
        List<Teacher> listTeacher = new ArrayList<>();
        Student student1 = new Student("Tinh1", LocalDate.of(2005,3,23),"09222321333");
        Student student2 = new Student("Tinh2", LocalDate.of(2004,1,4),"0922221333");
        Student student3 = new Student("Tinh3", LocalDate.of(2003,2,22),"0922312333");
        Student student4 = new Student("Tinh4", LocalDate.of(2004,1,4),"09223213233");
        Student student5 = new Student("Tinh5", LocalDate.of(2005,3,4),"0922312233");
        Student student6 = new Student("Tinh6", LocalDate.of(2005,2,12),"0927672233");
        Student student7 = new Student("Tinh7", LocalDate.of(2005,7,4),"092227733");
        Student student8 = new Student("Tinh8", LocalDate.of(2005,12,9),"0922662233");
        Student student9 = new Student("Tinh9", LocalDate.of(2004,3,4),"0924322233");
        Student student10 = new Student("Tinh10", LocalDate.of(2005,4,10),"0926722233");
        Student student11 = new Student("Tinh11", LocalDate.of(2004,3,11),"092321233");

        ClassRoom classRoom1 = new ClassRoom();

    }
}
