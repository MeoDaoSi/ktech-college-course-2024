package vn.edu.likelion.bai2.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    public static final String storeName = "ABC Store";

    // Constructor
    public Product(int productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Getter
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    // Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void showProductDisplay(){
        System.out.println("ID :" + this.productId);
        System.out.println("Product's Name: " + this.productName);
        System.out.println("Product's Price: " + this.price);
        System.out.println("Store's Name: " + storeName);
    }
}
