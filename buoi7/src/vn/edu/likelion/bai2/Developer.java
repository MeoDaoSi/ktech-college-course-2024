package vn.edu.likelion.bai2;

import vn.edu.likelion.bai2.Abstract.Employees;

public class Developer extends Employees {
    private int overtimeHours;
    private double hourlyRate;

    public int getOvertimeHours() {
        return overtimeHours;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Developer(String name, double baseSalary, int overtimeHours, double hourlyRate) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.overtimeHours = overtimeHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatorSalary() {
        return this.baseSalary + this.bonus + (this.overtimeHours * this.hourlyRate);
    }
    @Override
    public void displayInfo() {
        System.out.println("Programmer Name: " + this.name);
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Overtime Hours: " + this.overtimeHours);
        System.out.println("Hourly Rate: " + this.hourlyRate);
        System.out.println("Total Salary: " + this.calculatorSalary());
    }
}
