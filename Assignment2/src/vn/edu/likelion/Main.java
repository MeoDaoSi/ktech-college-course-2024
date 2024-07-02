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

        Student student1 = new Student("Tinh1", LocalDate.of(2005,3,23),"09222321333");
        Student student2 = new Student("Tinh2", LocalDate.of(2004,1,4),"0922221333");
        Student student3 = new Student("Tinh3", LocalDate.of(2005,2,22),"0922312333");
        Student student4 = new Student("Tinh4", LocalDate.of(2004,1,4),"09223213233");
        Student student5 = new Student("Tinh5", LocalDate.of(2002,3,4),"0922312233");
        Student student6 = new Student("Tinh6", LocalDate.of(2005,2,12),"0927672233");
        Student student7 = new Student("Tinh7", LocalDate.of(2005,7,4),"092227733");
        Student student8 = new Student("Tinh8", LocalDate.of(2005,12,9),"0922662233");
        Student student9 = new Student("Tinh9", LocalDate.of(2004,3,4),"0924322233");
        Student student10 = new Student("Tinh10", LocalDate.of(2005,4,10),"0926722233");
        Student student11 = new Student("Tinh11", LocalDate.of(2004,3,11),"092321233");
        Student student12 = new Student("Tinh12", LocalDate.of(2004,3,11),"0311021233");

        student11.setName("TinhSama");

        Teacher teacher1 = new Teacher("professor1", LocalDate.of(1990,3,4),"09243227773");
        Teacher teacher2 = new Teacher("professor2", LocalDate.of(1990,4,10),"0925555233");
        Teacher teacher3 = new Teacher("professor3", LocalDate.of(1990,3,11),"0966661233");

        ClassRoom classRoom1 = new ClassRoom();
        classRoom1.setName("Class Java");
        ClassRoom classRoom2 = new ClassRoom();
        classRoom2.setName("Class Javascript");
        ClassRoom classRoom3 = new ClassRoom();
        classRoom3.setName("Class PHP");

        classRoom1.addTeacher(teacher1);
        classRoom3.addTeacher(teacher1);
        teacher1.addCourse(classRoom1.getName());
        teacher1.addCourse(classRoom3.getName());

        classRoom1.addTeacher(teacher2);
        classRoom2.addTeacher(teacher2);
        classRoom2.addTeacher(teacher3);
        classRoom3.addTeacher(teacher3);

        classRoom1.enrol(student1);
        classRoom1.enrol(student2);
        classRoom1.enrol(student3);
        classRoom1.enrol(student4);
        classRoom1.enrol(student5);
        classRoom1.enrol(student6);
        classRoom1.enrol(student7);
        classRoom1.enrol(student8);
        classRoom1.enrol(student9);
        classRoom1.enrol(student10);
        classRoom1.enrol(student11);
        classRoom1.dismiss(student2,"lay chong khong muon hoc");

        classRoom1.showListInfo();
        classRoom1.showListTeacher();

        System.out.println("BlackList: " + classRoom1.getBlackList().entrySet());;
        System.out.println("Classroom1 start:" + classRoom1.getStartDate());

    }
}
