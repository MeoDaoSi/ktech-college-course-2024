package vn.edu.likelion.Model;

import vn.edu.likelion.Service.ICourse;

import java.util.ArrayList;
import java.util.List;

public class CourseOnline extends Course implements ICourse {
    private String platform;
    private int duration;
    private List<Student> list;

    public CourseOnline(){

    }
    public CourseOnline(
            int courseId,
            String courseName,
            String mentorName,
            int credit,
            String platform,
            int duration
    ){
        super(courseId,courseName,mentorName,credit);
        this.platform = platform;
        this.duration = duration;
        list = new ArrayList<>();
    }
    // Getter
    public String getPlatform() {
        return platform;
    }
    public int getDuration() {
        return duration;
    }
    public List<Student> getList() {
        return list;
    }
    // Setter
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setList(List<Student> list) {
        this.list = list;
    }
    //
    public void display(){
        for( Student e: list ){
            e.displayInfo();
        }
    }
    public void displayCourseInfo(){
        System.out.println("Id: " + super.getCourseId());
        System.out.println("Name Of Course: " + super.getCourseName());
        System.out.println("Name Of Mentor: " + super.getMentorName());
        System.out.println("Credit: " + super.getCredit());
    }
    public void enrol(Student student){
        list.add(student);
    }
}
