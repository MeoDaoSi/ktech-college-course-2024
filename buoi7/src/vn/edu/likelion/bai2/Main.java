package vn.edu.likelion.bai2;

import vn.edu.likelion.bai2.Abstract.Employees;

public class Main {
    public static void main(String[] args){
        Employees manager = new Manager("Corona Cadogan", 6000.0, 1000.0);
        Employees programmer = new Developer("Antal Nuka", 5000, 20, 25.0);

        manager.displayInfo();
        programmer.displayInfo();
    }
}
