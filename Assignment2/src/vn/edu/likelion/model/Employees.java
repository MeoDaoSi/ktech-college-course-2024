package vn.edu.likelion.model;

import java.time.LocalDate;

public class Employees {
    private String name;
    private LocalDate birthDate;
    private String cccd;
    // Constructor
    public Employees(){

    }
    public Employees(String name, LocalDate birthDate, String cccd){
        this.name = name;
        this.birthDate = birthDate;
        this.cccd = cccd;
    }
    // Getter
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
        System.out.println("First Name: " + this.name);
        System.out.println("Birth Date: " + this.birthDate);
        System.out.println("CCCD: " + this.cccd);
    }
}
