import Interface.UserMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User implements UserMethod {
    private int stt;
    private String name;
    private int age;
    private LocalDateTime dateBooked;
    private String nameRoomBooked;
    private int numberRoomBooked;
    private LocalDateTime dateReturn;

    // Constructor
    public User(
            int stt,
            String name,
            int age,
            LocalDateTime dateBooked,
            String nameRoomBooked,
            int numberRoomBooked
    ){
        this.stt = stt;
        this.name = name;
        this.age = age;
        this.dateBooked = dateBooked;
        this.nameRoomBooked = nameRoomBooked;
        this.numberRoomBooked = numberRoomBooked;
    }

    // ----- Get Method -----
    public int getStt() {
        return stt;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public LocalDateTime getDateBooked() {
        return dateBooked;
    }
    public String getNameRoomBooked() {
        return nameRoomBooked;
    }
    public int getNumberRoomBooked() {
        return numberRoomBooked;
    }
    public LocalDateTime getDateReturn() {
        return dateReturn;
    }
    // ----- Get Method -----

    // ----- Set Method -----
    public void setStt(int stt) {
        this.stt = stt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDateBooked(LocalDateTime dateBooked) {
        this.dateBooked = dateBooked;
    }
    public void setNameRoomBooked(String nameRoomBooked) {
        this.nameRoomBooked = nameRoomBooked;
    }
    public void setNumberRoomBooked(int numberRoomBooked) {
        this.numberRoomBooked = numberRoomBooked;
    }
    public void setDateReturn(LocalDateTime dateReturn) {
        this.dateReturn = dateReturn;
    }
    // ----- Set Method -----

    // ----- Interface -----
    public void showUserDisplay(){
        System.out.println("STT Khách Hàng: " + this.getStt());
        System.out.println("Tên Khách Hàng: " + this.getName());
        System.out.println("Tuổi Khách Hàng: " + this.getAge());
        System.out.println("Ngày Giờ Đặt Phòng: " + this.getDateBooked());
        System.out.println("Tên Phòng: " + this.getNameRoomBooked());
        System.out.println("Số Phòng: " + this.getNumberRoomBooked());
        System.out.println("Ngày Giờ Trả Phòng: " + this.getDateReturn());
    }
    public void addUser(){

    }
    public void editUser(){

    }
    public void removeUser(){

    }
    // ----- Interface -----

    // ----- Method Validate Input -----
    public static boolean validateAgeInput(int age){
        if( age < 18 ){
            System.out.println("Tuổi Không Hợp Lệ!");
            return false;
        }
        return true;
    }
    public static boolean validateDateInput(int date){
        if( date < LocalDate.now().getDayOfMonth() ){
            System.out.println("Không Thể Đặt Ngày Trong Quá Khứ!");
            return false;
        }
        return true;
    }
    // ----- Validate Input -----
}
