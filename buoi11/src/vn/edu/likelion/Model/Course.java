package vn.edu.likelion.Model;

public class Course {
    private int courseId;
    private String courseName;
    private String mentorName;
    private int credit;

    // Constructor
    public Course(){

    }
    public Course(int courseId, String courseName, String mentorName, int credit){
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
    }

    // Getter
    public int getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getMentorName() {
        return mentorName;
    }
    public int getCredit() {
        return credit;
    }
    // Setter
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void displayDetailCourse(){
        System.out.println("Course's Id: " + this.courseId);
        System.out.println("Course's Name: " + this.courseName);
        System.out.println("Mentor's Name: " + this.mentorName);
        System.out.println("Credit is: " + this.credit);
    }
}
