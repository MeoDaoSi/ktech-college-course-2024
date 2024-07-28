package vn.edu.likelion.store_manager.models;

import java.time.LocalDate;

public class Attribute {
    private int id;
    private String name;
    private int product_id;
    private String value;

    // ----- Getter -----
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getValue() {
        return value;
    }
    public int getProduct_id() {
        return product_id;
    }
    // ----- Getter -----
    // ----- Setter -----
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    // ----- Setter -----
}
