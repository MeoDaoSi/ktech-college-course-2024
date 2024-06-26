package vn.edu.likelion.bai2;

import vn.edu.likelion.bai2.Abstract.Employees;

public class Manager extends Employees {

    // Constructor
    public Manager(){

    }
    public Manager(String name, double baseSalary, double bonus){
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }
    // Getter


    public double calculatorSalary(){
        return this.baseSalary + this.bonus;
    }
    public void displayInfo(){
        System.out.println("Manager Name: " + this.name);
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Bonus: " + this.bonus);
        System.out.println("Total Salary: " + this.calculatorSalary());
    }

}
