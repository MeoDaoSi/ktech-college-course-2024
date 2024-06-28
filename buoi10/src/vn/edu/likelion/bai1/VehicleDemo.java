package vn.edu.likelion.bai1;

import vn.edu.likelion.bai1.model.Bike;
import vn.edu.likelion.bai1.model.Car;
import vn.edu.likelion.bai1.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args){
        List<Vehicle> vehicle = new ArrayList<>();
        Vehicle car = new Car(1001,"BMW",4);
        Vehicle bike = new Bike(1002,"Axtrox",true);
        vehicle.add(car);
        vehicle.add(bike);
        vehicle.get(0).move();
        vehicle.get(1).move();
        System.out.println("Number Of Vehicle: " + Vehicle.getVehicleCount());
    }
}
