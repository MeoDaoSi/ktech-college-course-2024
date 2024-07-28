package vn.edu.likelion.store_manager.models;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private int store_id;
    private int quantity;
    private float price;

    // ----- Getter -----
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getStore_id() {
        return store_id;
    }
    public int getQuantity() {
        return quantity;
    }
    public float getPrice() {
        return price;
    }
    // ----- Getter -----
    // ----- Setter -----
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setId(int id) {
        this.id = id;
    }
    // ----- Setter -----
}
