import java.util.Date;

public class Room {
    private int STT;
    private String roomID;
    private String roomName;
    private int roomNumber;
    private boolean roomStatus;
    private User info;
    private Date booked;

    public Room(){

    }

    public Room(int STT, String roomName, int roomNumber){
        this.STT = STT;
        this.roomID = "ID" + roomNumber;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.roomStatus = false;
    }

    public int getSTT(){
        return this.STT;
    }

    public String getRoomId(){
        return this.roomID;
    }

    public String getRoomName(){
        return this.roomName;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public Boolean getRoomStatus(){
        return this.roomStatus;
    }

    public User getInfo(){
        return this.info;
    }

    public Date getBooked(){
        return this.booked;
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }
}
