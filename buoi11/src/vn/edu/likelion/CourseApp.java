package vn.edu.likelion;

import vn.edu.likelion.Model.CourseOnline;
import vn.edu.likelion.Model.Student;

public class CourseApp {
    public static void main(String[] args){
        CourseOnline course = new CourseOnline(
                1001,
                "Jav On Top",
                "Tran Hao Nam",
                3,
                "Youtube",
                12
        );
        // Add student
        Student student1 = new Student(1001,"Duong1");
        Student student2 = new Student(2001,"Duong2");
        Student student3 = new Student(3001,"Duong3");
        Student student4 = new Student(4001,"Duong4");
        course.enrol(student1);
        course.enrol(student2);
        course.enrol(student3);
        course.enrol(student4);

        // Show Course Info and Student Info
        course.displayCourseInfo();
        course.display();
    }
}
