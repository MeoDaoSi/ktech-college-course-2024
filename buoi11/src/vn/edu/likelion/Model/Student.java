package vn.edu.likelion.Model;

import vn.edu.likelion.Service.IStudent;

public class Student implements IStudent {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    // Getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    // Setter
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Interface
    public void displayInfo(){
        System.out.println("Id of Student: " + id);
        System.out.println("Name of Student: " + name);
    }
}
