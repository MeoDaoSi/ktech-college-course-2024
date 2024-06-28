package vn.edu.likelion.bai1.model;

public class Car extends Vehicle{
    private int numberOfDoors;

    // Constructor
    public Car(int id, String name, int numberOfDoors){
        super(id,name);
        this.numberOfDoors = numberOfDoors;
    }
    // Getter
    // Inheritance Getter
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    // Setter
    // Inheritance Setter
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void move() {
        System.out.println(this.getName() + " is move");
    }
}
