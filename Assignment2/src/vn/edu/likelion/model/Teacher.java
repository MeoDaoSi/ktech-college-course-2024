package vn.edu.likelion.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher extends Employees{
    private int maGV;
    private List<String> list = new ArrayList<>();
    private final int totalCourse = 2;
    public Teacher(){

    }
    public Teacher(String name, LocalDate birthDate, String cccd){
        super(name,birthDate,cccd);
        maGV = (int) (Math.random()*100);
    }
    // Getter
    public int getMaGV() {
        return maGV;
    }
    public String getName() {
        return super.getName();
    }
    public LocalDate getBirthDate() {
        return super.getBirthDate();
    }
    public String getCccd() {
        return super.getCccd();
    }
    public List<String> getList() {
        return list;
    }
    public int getTotalCourse() {
        return totalCourse;
    }
    // Setter
    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }
    public void setName(String name) {
        super.setName(name);
    }
    public void setBirthDate(LocalDate birthDate) {
        super.setBirthDate(birthDate);
    }
    public void setCccd(String cccd) {
        super.setCccd(cccd);
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    // Add a course to the teacher
    public void addCourse(String nameCourse){
        list.add(nameCourse);
    }

    @Override
    // Override method showInfo from Employees class
    public void showInfo(){
        System.out.println("ID Teacher: " + maGV);
        System.out.println("Classroom: " + list);
        super.showInfo();
    }

}
