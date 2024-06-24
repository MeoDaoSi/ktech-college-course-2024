import java.util.ArrayList;

public class Manager{
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

    // ----- Get Method -----
    public ArrayList<Room> getListRoom() {
        return listRoom;
    }
    public ArrayList<User> getListUser() {
        return listUser;
    }
    public int getTotalRoom() {
        return totalRoom;
    }
    public int getTotalUser() {
        return totalUser;
    }
    // ----- Get Method -----

    // ----- Set Method -----
    public void addRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }
    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }
    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }
    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }
    // ----- Set Method -----

    // Hàm In Ra Danh Sách Phòng
    public void showAllRoom(){
        if( this.getTotalRoom() == 0 ){
            System.out.println("Danh Sách Phòng Đang Rỗng, Hãy Thêm Phòng!");
        }else {
            for(int i = 0; i<this.getTotalRoom(); i++ ){
                System.out.println("Phòng " + (i + 1));
                this.getListRoom().get(i).showRoomDisplay();
            }
        }
    }
    // Hàm In Ra Danh Sách Users
    public void showAllUser(){
        if( this.getTotalUser() == 0 ){
            System.out.println("Danh Sách User Đang Rỗng, Hãy Đặt Phòng!");
        }else {
            for(int i = 0; i<this.getTotalUser() ; i++ ){
                this.getListUser().get(i).showUserDisplay();
            }
        }
    }
    // Hàm Tìm Phòng Theo ID - Trả Về: Đối Tượng Room
    public Room getRoom(String id){
        for( Room e: getListRoom() ){
            if( e.getId().equals(id) ){
                return e;
            }
        }
        return this.listRoom.get(0);    // Cần Fix
    }
    // Hàm Tìm User Theo Tên - Trả Về: Đối Tượng User
    public User getUser(String name){
        for( User e: getListUser()){
            if( e.getName().equals(name) ){
                return e;
            }
        }
        return this.listUser.get(0);    // Cần Fix
    }
    // Hàm Tìm Phòng Theo Yêu Cầu Của User - Trả Về: Đối Tượng Room
    public Room getRoomByUser(String name){
        for( Room e: getListRoom()){
            if( e.getName().equals(name) ){
                return e;
            }
        }
        return this.listRoom.get(0);    // Cần Fix
    }
    // Hàm Thêm Phòng Mới Vào Danh Sách Phòng
    public void addRoom(Room room) {
        getListRoom().add(room);
        setTotalRoom(getTotalRoom() + 1);
    }
    // Hàm Xóa Phòng Trong Danh Sách Phòng
    public void removeRoom(String id){
        getListRoom().remove(getRoom(id));
        setTotalRoom(getTotalRoom() - 1);
    }
    public void addUser(User user) {
        getListUser().add(user);
        setTotalUser(getTotalUser() + 1);
    }

    // ----- Method Validate -----
    public boolean validateRoomName(String name){
        for ( Room e: getListRoom() ){
            if( e.getName().equals(name) ){
                return true;
            }
        }
        return false;
    }
    public boolean validateRoomNumber(int number){
        for ( Room e: getListRoom() ){
            if( e.getNumber() == number ){
                return true;
            }
        }
        return false;
    }
    public boolean validateExistUser(String name){
        for ( User e: getListUser() ){
            if( e.getName().equals(name) ){
                return true;
            }
        }
        return false;
    }
    // ----- Method Validate -----


//    public boolean isRoom(String id){
//        for( Room e: this.listRoom){
//            if( e.getRoomId().equals(id) ){
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean isUser(String name){
//        for( User e: this.listUser){
//            if( e.getName().equals(name) ){
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean matchRoom(String name, int number){
//        for( Room e: this.listRoom){
//            if( e.getName().equals(name) && e.getNumber() == number ){
//                return true;
//            }
//        }
//        return false;
//    }

}
