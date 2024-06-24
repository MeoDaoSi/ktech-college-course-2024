import java.util.ArrayList;

public class Manager {
    private ArrayList<Room> listRoom;
    private ArrayList<User> listUser;
    private int totalRoom;
    private int totalUser;

    // Hàm Contractor
    public Manager(){
        this.listRoom = new ArrayList<Room>();
        this.listUser = new ArrayList<User>();
        totalRoom=0;
        totalUser=0;
    }

    // Hàm In Ra Danh Sách Phòng
    public void getAllRoom(){
        if( this.totalRoom == 0 ){
            System.out.println("Danh Sách Phòng Đang Rỗng, Hãy Thêm Phòng!");
        }else {
            for(int i = 0; i<this.totalRoom; i++ ){
                System.out.println("Phòng " + (i + 1));
                System.out.println("STT Phòng: " + this.listRoom.get(i).getSTT());
                System.out.println("ID Phòng: " + this.listRoom.get(i).getRoomId());
                System.out.println("Tên Phòng: " + this.listRoom.get(i).getRoomName());
                System.out.println("Số Phòng: " + this.listRoom.get(i).getRoomNumber());
                System.out.println("Trạng Thái Phòng: " + this.listRoom.get(i).getRoomStatus());
                System.out.println("Thông Tin Khách Đặt Phòng: ");
                System.out.println("Ngày Đặt Phòng: ");
            }
        }
    }

    public void getAllUser(){
        if( this.totalUser == 0 ){
            System.out.println("Danh Sách User Đang Rỗng, Hãy Đặt Phòng!");
        }else {
            for(int i = 0; i<this.totalUser; i++ ){
                System.out.println("STT Khách Hàng: " + this.listUser.get(i).getSTT());
                System.out.println("Tên Khách Hàng: " + this.listUser.get(i).getName());
                System.out.println("Tuổi Khách Hàng: " + this.listUser.get(i).getAge());
                System.out.println("Ngày Giờ Đặt Phòng: " + this.listUser.get(i).getDateBooked());
                System.out.println("Tên Phòng: " + this.listUser.get(i).getNameRoomBooked());
                System.out.println("Số Phòng: " + this.listUser.get(i).getNumberRoomBooked());
            }
        }
    }

    public boolean isRoom(String id){
        for( Room e: this.listRoom){
            if( e.getRoomId().equals(id) ){
                return true;
            }
        }
        return false;
    }

    public boolean isUser(String name){
        for( User e: this.listUser){
            if( e.getName().equals(name) ){
                return true;
            }
        }
        return false;
    }

    public boolean matchRoom(String name, int number){
        for( Room e: this.listRoom){
            if( e.getRoomName().equals(name) && e.getRoomNumber() == number ){
                return true;
            }
        }
        return false;
    }

    public Room getRoom(String id){
        for( Room e: this.listRoom){
            if( e.getRoomId().equals(id) ){
                return e;
            }
        }
        return this.listRoom.get(0);
    }

    public Room getRoomForUser(String name){
        for( Room e: this.listRoom){
            if( e.getRoomName().equals(name) ){
                return e;
            }
        }
        return this.listRoom.get(0);
    }

    public void printRoom(String id){
        for( Room e: this.listRoom){
            if( e.getRoomId().equals(id) ){
                System.out.println("ID Phòng: " + e.getRoomId());
                System.out.println("Tên Phòng: " + e.getRoomName());
                System.out.println("Số Phòng: " + e.getRoomNumber());
//                if( e.getInfo().getName() == null ){
//                    System.out.println("Phòng Trống!");
//                }else{
//                    System.out.println("STT Khách Hàng: " + e.getSTT());
//                    System.out.println("Tên Khách Hàng: " + e.getInfo().getName());
//                    System.out.println("Tuổi Khách Hàng: " + e.getInfo().getAge());
//                    System.out.println("Ngày Giờ Đặt Phòng: " + e.getInfo().getDateBooked());
//                }
            }
        }
    }

    public User getUser(String name){
        for( User e: this.listUser){
            if( e.getName().equals(name) ){
                return e;
            }
        }
        return this.listUser.get(0);
    }

    public void setListRoom(Room room) {
        this.listRoom.add(room);
        this.totalRoom++;
    }

    public void removeRoom(String id){
        this.listRoom.remove(getRoom(id));
        this.totalRoom--;
    }

    public void setListUser(User user) {
        this.listUser.add(user);
        totalUser++;
    }

    public int getTotalRoom(){
        return this.totalRoom;
    }
    public int getTotalUser(){
        return this.totalUser;
    }

}
