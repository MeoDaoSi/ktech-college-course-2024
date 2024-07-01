package vn.edu.likelion.model;

import java.time.LocalDate;

public class Student {
    private int mssv;
    private String name;
    private LocalDate birthDate;
    private String cccd;
    // Constructor
    public Student(){

    }
    public Student(String name, LocalDate birthDate, String cccd){
        this.name = name;
        this.birthDate = birthDate;
        this.cccd = cccd;
    }
    // Getter
    public int getMssv() {
        return mssv;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getCccd() {
        return cccd;
    }
    // Setter
    public void setMssv(int mssv) {
        this.mssv = mssv;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void showInfo(){
        System.out.println("MSSV: " + this.mssv);
        System.out.println("First Name: " + this.name);
        System.out.println("Birth Date: " + this.birthDate);
        System.out.println("CCCD: " + this.cccd);
    }
}
