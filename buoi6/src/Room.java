import Interface.RoomMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Room implements RoomMethod {
    private int stt;
    private String id;
    private String name;
    private int number;
    private boolean status;
    private User info;
    private LocalDateTime booked;

    // Constructor
    public Room(){

    }
    // Constructor
    public Room(int stt, String name, int number){
        this.stt = stt;
        this.id = "ID" + number;
        this.name = name;
        this.number = number;
        this.status = false;
    }

    // ----- Get Method -----
    public int getStt(){
        return this.stt;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getNumber(){
        return this.number;
    }
    public Boolean getStatus(){
        return this.status;
    }
    public User getInfo(){
        return this.info;
    }
    public LocalDateTime getBooked(){
        return this.booked;
    }
    // ----- Get Method -----

    // ----- Set Method -----
    public void setStt(int stt) {
        this.stt = stt;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setInfo(User info) {
        this.info = info;
    }
    public void setBooked(LocalDateTime booked) {
        this.booked = booked;
    }
    // ----- Set Method -----

    // ----- Interface -----
    public String format(LocalDateTime dateTime){
        if( dateTime != null ){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            return formattedDateTime;
        }
        return null;

    }
    public void showRoomDisplay(){
        System.out.println("STT Phòng: " + this.getStt());
        System.out.println("ID Phòng: " + this.getId());
        System.out.println("Tên Phòng: " + this.getName());
        System.out.println("Số Phòng: " + this.getNumber());
        System.out.println("Trạng Thái Phòng: " + this.getStatus());
        System.out.println("Thông Tin Khách Đặt Phòng: ");
        if( getInfo() != null ){
            System.out.println("Tên Khách Hàng: " + getInfo().getName());
            System.out.println("Tuổi Khách Hàng: " + getInfo().getAge());
        }
        System.out.println("Ngày Đặt Phòng: " + format(getBooked()));
    }
    public void addRoom(){

    }
    public void editRoom(){

    }
    public void removeRoom(){

    }
    // ----- Interface -----

}
