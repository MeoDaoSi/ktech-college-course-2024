package vn.edu.likelion.store_manager;

import org.apache.poi.ss.usermodel.*;
import vn.edu.likelion.store_manager.db.Connect;
import vn.edu.likelion.store_manager.models.Attribute;
import vn.edu.likelion.store_manager.models.Product;
import vn.edu.likelion.store_manager.models.Store;
import vn.edu.likelion.store_manager.models.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static User user = null;
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Attribute> attributes = new ArrayList<>();
    private static Store store = null;
    private static void initConnect(Connect connect, PreparedStatement statement, ResultSet rs) throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(new File("DanhSachSP.xlsx"));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for( Row row: sheet ){
            if( row.getRowNum() <= 4 || row.getRowNum() > 12 ) continue;
            Product product = new Product();
            for( Cell cell: row ){
                switch (cell.getColumnIndex()){
                    case 0:
                        product.setId((int)(Math.random()*1000));
                        break;
                    case 1:
                        product.setName(cell.getStringCellValue());
                        break;
                    case 2:
                        String[] arrAttribute = cell.getStringCellValue().split("\n",10);
                        for( String e: arrAttribute ){
                            Attribute attribute = new Attribute();
                            attribute.setId((int)(Math.random()*10000));
                            attribute.setName("Hardware");
                            attribute.setValue(e);
                            attribute.setProduct_id(product.getId());
                            attributes.add(attribute);
                        }
                        break;
                    case 3:
                        product.setQuantity((int)cell.getNumericCellValue());
                        break;
                    case 4:
                        product.setPrice((float)cell.getNumericCellValue());
                        break;
                    default:
                        break;
                }
            }
            products.add(product);
            workbook.close();
            inputStream.close();
        }
    }

    public static void main(String[] args) {

        Connect connect = new Connect();
        PreparedStatement statement = null;
        ResultSet rs = null;

        while(true){

            int choice = 0;
            try{
                if(products.isEmpty()){
                    initConnect(connect,statement,rs);
                }
            }catch(FileNotFoundException ex1){
                System.out.println("File Not Founded!");
            }catch (IOException ex2){
                System.out.println("IOException!");
            }

            showMenu();

            try{
                choice = sc.nextInt();
            }catch(InputMismatchException exception){
                System.out.println("Invalid Input!");
            }

            switch(choice){
                case 1:
                    System.out.println("Enter Username:");
                    String username = sc.next();
                    System.out.println("Enter Password");
                    String password = sc.next();
                    user = new User();
                    try{
                        // Open Connect
                        connect.openConnect();
                        user = user.login(connect,statement,rs,username,password);
                    }catch(SQLException ex1){
                        System.out.println(ex1.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 2:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter Username");
                    username = sc.next();
                    System.out.println("Enter Password");
                    password = sc.next();

                    try{
                        // Open Connect
                        connect.openConnect();
                        user.addUser(connect,statement,rs,username,password);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 3:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter Username");
                    username = sc.next();
                    System.out.println("Enter New Password");
                    password = sc.next();

                    try{
                        // Open Connect
                        connect.openConnect();
                        user.changePassword(connect,statement,rs,username,password);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 4:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter User ID:");
                    int id = sc.nextInt();

                    try{
                        // Open Connect
                        connect.openConnect();
                        user.remove(connect,statement,rs,id);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 5:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    try{
                        // Open Connect
                        connect.openConnect();
                        getAllStore(connect,statement,rs);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 6:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter Store Name: ");
                    String storeName = sc.next();
                    System.out.println("Assign User To Store:");
                    System.out.println("Enter 0 To Skip");
                    int user_id = sc.nextInt();
                    try{
                        // Open Connect
                        connect.openConnect();
                        addStore(connect,statement,rs,storeName,user_id);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 7:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter Store ID: ");
                    int store_id = sc.nextInt();
                    System.out.println("Enter New Store Name: ");
                    String newName = sc.next();
                    System.out.println("Enter User ID: ");
                    user_id = sc.nextInt();
                    try{
                        // Open Connect
                        connect.openConnect();
                        editStore(connect,statement,rs,store_id,newName,user_id);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 8:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter Store ID: ");
                    store_id = sc.nextInt();
                    System.out.println("Enter New Store ID: ");
                    int newStore = sc.nextInt();
                    try{
                        // Open Connect
                        connect.openConnect();
                        removeStore(connect,statement,rs,store_id,newStore);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 9:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.println("Enter Store ID: ");
                    store_id = sc.nextInt();
                    try{
                        // Open Connect
                        connect.openConnect();
                        addProduct(connect,statement,rs,store_id);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 10:
                    // Check Permission
                    if(!user.getRole().equals("ADMIN")){
                        System.out.println("Access Denied!");
                        break;
                    }
                    try{
                        // Open Connect
                        connect.openConnect();
                        displayAllProduct(connect,statement,rs);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 11:
                    System.out.println("Enter Store ID: ");
                    store_id = sc.nextInt();
                    try{
                        // Open Connect
                        connect.openConnect();
                        addProduct(connect,statement,rs,store_id);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 12:
                    System.out.println("Enter Store ID: ");
                    store_id = sc.nextInt();
                    try{
                        // Open Connect
                        connect.openConnect();
                        displayProduct(connect,statement,rs,store_id);
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }finally{
                        try{
                            // Close Connect
                            connect.closeConnect();
                        }catch(SQLException ex1){
                            System.out.println(ex1.getMessage());
                        }
                    }
                    break;
                case 0:
                    user = null;
                    break;
                default: {
                    break;
                }
            }

        }

    }
    // ----- Method Display Menu -----
    private static void showMenu() {
        System.out.println(" ========= MENU ========= ");
        if (user == null) {
            System.out.println("1. Please Login!");
        }
        if (user != null && user.getRole().equals("ADMIN")) {
            System.out.println("2. Add User");
            System.out.println("3. Edit User");
            System.out.println("4. Remove User");
            System.out.println("5. Show All Stores");
            System.out.println("6. Add Store");
            System.out.println("7. Edit Store");
            System.out.println("8. Remove Store");
            System.out.println("9. Add Product");
            System.out.println("10. Show All Products");
            System.out.println("0. Log out");
        }
        if(user != null && user.getRole().equals("USER")){
            System.out.println("11. Add Product");
            System.out.println("12. Show Detail Store!");
            System.out.println("0. Log out");
        }
        System.out.println(" ======================== ");
        System.out.print("Choose Operation: ");
    }
    // ----- Method Display All Store -----
    public static void getAllStore(
            Connect connect, PreparedStatement statement, ResultSet rs
    ) throws SQLException {
        String SQLQuery = "Select * from tb1_stores";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        rs = statement.executeQuery();
        while(rs.next()){
            System.out.print(rs.getInt(1) + "\t\t");
            System.out.println(rs.getString(2));
        }
    }
    // ----- Method Display detail Store -----
    public static Store getDetailStore(
            Connect connect, PreparedStatement statement, ResultSet rs, int id
    ) throws SQLException {
        String SQLQuery = "Select * from tb1_stores where id=? ";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setInt(1,id);
        rs = statement.executeQuery();
        if(!rs.next()){
            System.out.println("----- Store Not Founded -----");
            return null;
        }
        return new Store(rs.getInt(1),rs.getString(2),rs.getInt(3));
    }
    // ----- Method Add Store -----
    public static void addStore(
            Connect connect, PreparedStatement statement, ResultSet rs, String name, int user_id
    ) throws SQLException {
        String SQLQuery = "";
        if(!(user_id == 0)) SQLQuery = "insert into tb1_stores values(?,?,?)";
        else SQLQuery = "insert into tb1_stores(id,name) values(?,?)";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setInt(1,(int)(Math.random()*100));
        statement.setString(2,name);
        if(!(user_id == 0)){
            statement.setInt(3,user_id);
        }
        statement.executeQuery();
        System.out.println("Add Store Success");
    }
    // ----- Method Add Store -----
    public static void editStore(
            Connect connect, PreparedStatement statement, ResultSet rs, int id, String name, int user_id
    ) throws SQLException {
        String SQLQuery = "update tb1_stores set name=?, user_id=? where id=? ";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setString(1,name);
        statement.setInt(2,user_id);
        statement.setInt(3,id);
        statement.executeQuery();
        System.out.println("Store Updated");
    }
    public static void addProduct(
            Connect connect, PreparedStatement statement, ResultSet rs, int store_id
    ) throws SQLException {
        store = getDetailStore(connect,statement,rs,store_id);
        if( store == null ){
            return;
        }
        if( store.getUser_id()==0 ){
            System.out.println("Please Assign To User !");
        }
        if( user.getRole().equals("USER") && user.getId()!= store.getUser_id() ){
            System.out.println("Can Not Add Product To Store !");
            return;
        }
        String SQLQuery = "Insert into tb1_products values(?,?,?,?,?)";
        for (Product product : products) {
            statement = connect.getConnect().prepareStatement(SQLQuery);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, store_id);
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getQuantity());
            statement.executeQuery();
        }
        String SQLQuery1 = "Insert into tb1_attributes values(?,?,?,?)";
        for (Attribute attribute : attributes) {
            statement = connect.getConnect().prepareStatement(SQLQuery1);
            statement.setInt(1, attribute.getId());
            statement.setString(2, attribute.getName());
            statement.setInt(3, attribute.getProduct_id());
            statement.setString(4, attribute.getValue());
            statement.executeQuery();
        }
        products.clear();
        attributes.clear();
        System.out.println("Add Product Success!");
    }
    // Method Display All Product
    public static void displayAllProduct(
            Connect connect, PreparedStatement statement, ResultSet rs
    ) throws SQLException {
        String SQLQuery = "select * from tb1_products";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        rs = statement.executeQuery();
        System.out.println("Name" + "\t" + "Store" + "\t" + "Price" + "\t" + "Quantity");
        while(rs.next()){
            store = getDetailStore(connect,statement,rs,rs.getInt(3));
            System.out.print(rs.getString(2) + "\t");
            System.out.print(store.getName() + "\t");
            System.out.print(rs.getDouble(4) + "\t");
            System.out.print(rs.getInt(5) + "\n");
        }
    }
    public static void displayProduct(
            Connect connect, PreparedStatement statement, ResultSet rs, int store_id
    ) throws SQLException {
        String SQLQuery = "select * from tb1_products where store_id=?";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setInt(1, store_id);
        rs = statement.executeQuery();
        System.out.println("Name" + "\t" + "Store" + "\t" + "Price" + "\t" + "Quantity");
        while(rs.next()){
            store = getDetailStore(connect,statement,rs,rs.getInt(3));
            System.out.print(rs.getString(2) + "\t");
            System.out.print(store.getName() + "\t");
            System.out.print(rs.getDouble(4) + "\t");
            System.out.print(rs.getInt(5) + "\n");
            displayAttributes(connect,statement,rs,rs.getInt(1));
        }
    }
    public static void removeStore(
            Connect connect, PreparedStatement statement, ResultSet rs, int store_id, int newStore
    ) throws SQLException {
        String SQLQuery = "UPDATE tb1_products \n" +
                "SET store_id = ? \n" +
                "WHERE store_id = ?";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setInt(1, newStore);
        statement.setInt(2, store_id);
        statement.executeQuery();

        // Sql Delete
        String SQLQuery1 = "DELETE FROM TB1_STORES WHERE id=?";
        statement = connect.getConnect().prepareStatement(SQLQuery1);
        statement.setInt(1, store_id);
        statement.executeQuery();
        System.out.println("Delete Success !");
    }
    public static void displayAttributes(
            Connect connect, PreparedStatement statement, ResultSet rs, int product_id
    ) throws SQLException {
        String SQLQuery = "select * from tb1_attributes where product_id=?";
        statement = connect.getConnect().prepareStatement(SQLQuery);
        statement.setInt(1, product_id);
        rs = statement.executeQuery();
        while(rs.next()){
            System.out.print(rs.getString(2) + "\t");
            System.out.print(rs.getString(4) + "\n");
        }
        System.out.println("====================");
    }
}
