package vn.edu.likelion.Service;

import vn.edu.likelion.Model.Student;

public interface ICourse {
    void displayCourseInfo(); // Show information of course
    void display(); // show list of students
    void enrol(Student student); // enrol membership
}
