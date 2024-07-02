package vn.edu.likelion.model;

import java.time.LocalDate;

public class Student extends Employees{
    private int maHV;
    // Constructor
    public Student(){
        super();
    }
    public Student(String name, LocalDate birthDate, String cccd){
        super(name,birthDate,cccd);
    }
    // Getter
    public int getMaHV() {
        return maHV;
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
    // Setter
    public void setId(int maHV) {
        this.maHV = maHV;
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
    @Override
    // Override method showInfo from Employees class
    public void showInfo(){
        System.out.println("ID Student: " + maHV);
        super.showInfo();
    }
}
