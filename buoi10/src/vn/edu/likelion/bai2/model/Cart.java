package vn.edu.likelion.bai2.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products;

    // Constructor
    public Cart(){
        products = new ArrayList<>();
    }

    // Getter
    public List<Product> getProducts() {
        return products;
    }
    // Setter
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addToCart(Product product){
        this.products.add(product);
    }
    public double totalPrice(){
        double totalPrice = 0;
        for( Product e: this.products){
            totalPrice+=e.getPrice();
        }
        return totalPrice;
    }
}
