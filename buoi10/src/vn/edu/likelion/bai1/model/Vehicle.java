package vn.edu.likelion.bai1.model;

public abstract class Vehicle {
    private String name;
    private final int id;
    private static int vehicleCount;

    // Constructor
    public Vehicle(int id, String name){
        this.id = id;
        this.name = name;
        vehicleCount++;
    }

    // Getter
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public static int getVehicleCount() {
        return vehicleCount;
    }
    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public static void setVehicleCount(int vehicleCount) {
        Vehicle.vehicleCount = vehicleCount;
    }

    // Abstract Method
    public abstract void move();
}
