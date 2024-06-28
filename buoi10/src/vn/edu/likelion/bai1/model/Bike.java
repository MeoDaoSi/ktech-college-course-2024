package vn.edu.likelion.bai1.model;

public class Bike extends Vehicle{
    private boolean hasGear;
    // Constructor
    public Bike(int id, String name, boolean hasGear){
        super(id,name);
        this.hasGear = hasGear;
    }
    // Getter
    // Inheritance Getter
    public boolean isHasGear() {
        return hasGear;
    }
    // Setter
    // Inheritance Setter
    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }

    @Override
    public void move() {
        System.out.println(this.getName() + " is move");
    }
}
