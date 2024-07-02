package vn.edu.likelion.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRoom {
    private String name;
    private List<Student> list = new ArrayList<>();
    private int totalList;
    private LocalDate StartDate;
    private Map<String, String> blackList = new HashMap<>();
    private List<Teacher> listTeacher = new ArrayList<>();;

    // Getter
    public String getName(){
        return name;
    }
    public List<Student> getList() {
        return list;
    }
    public int getTotalList() {
        return totalList;
    }
    public LocalDate getStartDate() {
        return StartDate;
    }
    public List<Teacher> getListTeacher() {
        return listTeacher;
    }
    public Map<String, String> getBlackList() {
        return blackList;
    }
    // Setter
    public void setName(String name){
        this.name = name;
    }
    public void setList(List<Student> list) {
        this.list = list;
    }
    public void setTotalList(int totalList) {
        this.totalList = totalList;
    }
    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }
    public void setListTeacher(List<Teacher> listTeacher) {
        this.listTeacher = listTeacher;
    }
    public void setBlackList(Map<String, String> blackList) {
        this.blackList = blackList;
    }
     // Enrolls a student in the member system.
     // This method adds a student to the member list if the student is not already enrolled.
    public void enrol(Student student){
        if( totalList < 10 && memberShipRequirements(student)){
            this.list.add(student);
            totalList++;
            student.setId(1000 + totalList);
        }
        if( totalList == 10){
            StartDate = LocalDate.now();
        }
    }
    // Removes a student from the member list.
    public void dismiss(Student student, String reason){
        blackList.put(student.getName(),reason);
        this.list.remove(student);
        totalList--;
    }
    // Displays full information of all students in the member list.
    public void showListInfo(){
        for( Student e: list ){
            e.showInfo();
        }
    }
    // Method checks if a student meets the requirements to enroll as a member.
    public boolean memberShipRequirements(Student student){
        int AgeRequirements = LocalDate.now().getYear() - student.getBirthDate().getYear();
        return AgeRequirements >= 18 && AgeRequirements <= 20;
    }
    // Method adds a teacher to the member system
    public void addTeacher(Teacher teacher){
        listTeacher.add(teacher);
    }
    // Displays full information of all teachers in the member list.
    public void showListTeacher(){
        for( Teacher e: listTeacher ){
            e.showInfo();
        }
    }
}
