package vn.edu.likelion.bai2;

import vn.edu.likelion.bai2.model.Cart;
import vn.edu.likelion.bai2.model.Product;

public class ShoppingApp {
    public static void main(String[] args){
        Product product1 = new Product(1001,"shovel", 500.00);
        Product product2 = new Product(1002,"charcoal", 100.00);
        Cart cart = new Cart();
        cart.addToCart(product1);
        cart.addToCart(product2);
        for ( Product e: cart.getProducts() ){
            e.showProductDisplay();
        }
        System.out.println("Total Prices: " + cart.totalPrice());
    }
}
