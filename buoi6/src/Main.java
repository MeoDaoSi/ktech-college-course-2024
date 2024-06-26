import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){

        Manager manager = new Manager(); // Tạo Đối Tượng Quản lý - Quản Lý Phòng Và Khách Hàng

        int thaoTacTrangChu;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("----------- TRANG CHỦ -----------");
            System.out.println("1. Xem Danh Sách Phòng");
            System.out.println("2. Xem Danh Sách Khách Hàng");
            System.out.println("0. Thoát !!!");
            System.out.println("Chọn Thao Tác:");

            thaoTacTrangChu = sc.nextInt();

            switch (thaoTacTrangChu){
                case 0:
                    break;
                case 1:
                    int thaoTacTrangDS;
                    do{
                        System.out.println("----------- Trang Danh Sách Phòng -----------");
                        manager.showAllRoom();
                        System.out.println("1. Xem Chi Tiết Phòng");
                        System.out.println("2. Thêm Phòng");
                        System.out.println("0. Thoát !!!");
                        System.out.println("Chọn Thao Tác:");
                        thaoTacTrangDS = sc.nextInt();
                        switch (thaoTacTrangDS){
                            case 0:
                                break;
                            case 1:
                                System.out.println("Nhập ID Phòng:");
                                String id = sc.next();
                                int thaoTacTrangChiTiet;
                                System.out.println("----------- Trang Chi Tiết Phòng -----------");
                                manager.getRoom(id).showRoomDisplay();
                                System.out.println("1. Sửa Phòng");
                                System.out.println("2. Xóa Phòng");
                                System.out.println("0. Thoát !!!");

                                System.out.println("Chọn Thao Tác:");
                                thaoTacTrangChiTiet = sc.nextInt();
                                switch (thaoTacTrangChiTiet){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.println("Nhập Tên Mới: ");
                                        String newRoomName = sc.next();
                                        System.out.println("Nhập Số Phòng Mới: ");
                                        int newRoomNumber = sc.nextInt();
                                        manager.getRoom(id).setName(newRoomName);
                                        manager.getRoom(id).setNumber(newRoomNumber);
                                        break;
                                    case 2:
                                        manager.removeRoom(id);
                                        break;
                                }
                                break;
                            case 2:
                                if(manager.getTotalRoom() == 5){
                                    System.out.println("Số Phòng Đã Đạt 5, Không Thể Thêm!");
                                    break;
                                }
                                System.out.println("Nhập Tên Phòng:");
                                String name = sc.next();
                                System.out.println("Nhập Số Phòng:");
                                int number = sc.nextInt();
                                Room room = new Room(manager.getTotalRoom() + 1, name, number);
                                manager.addRoom(room);
                                System.out.println("Thêm Phòng Thành Công!");
                                break;
                            default:
                                System.out.println("Thao Tác Không Hợp Lệ!!!");
                                break;
                        }
                    }while(thaoTacTrangDS != 0);
                    break;
                case 2:
                    int thaoTacTrangUser;
                    do{
                        System.out.println("----------- Trang Danh Sách User -----------");
                        manager.showAllUser();
                        System.out.println("1. Đặt Phòng");
                        System.out.println("2. Trả Phòng");
                        System.out.println("0. Thoát !!!");
                        System.out.println("Chọn Thao Tác:");
                        thaoTacTrangUser = sc.nextInt();
                        switch (thaoTacTrangUser){
                            case 0:
                                break;
                            case 1:
                                System.out.println("Vui Lòng Nhập Tên:");
                                String nameUser = sc.next();
                                if( manager.validateExistUser(nameUser) ){
                                    System.out.println("Không Được Nhập Trùng Tên!");
                                }
                                System.out.println("Vui Lòng Nhập Tuổi:");
                                int ageUser = sc.nextInt();
                                if( !User.validateAgeInput(ageUser) ) break;
                                System.out.println("Ngày Đặt Phòng: ");
                                int date = sc.nextInt();
                                if( !User.validateDateInput(date) ) break;
                                System.out.println("Giờ Đặt Phòng: ");
                                int time = sc.nextInt();
                                LocalDateTime bookedDate = LocalDateTime.of(
                                        LocalDateTime.now().getYear(),
                                        LocalDateTime.now().getMonth(),
                                        date,
                                        time,
                                        0);

                                System.out.println("Nhập Tên Phòng: ");
                                String nameRoomBooked = sc.next();
                                if (!manager.validateRoomName(nameRoomBooked)) break; // Kiểm Tra Tên Phòng
                                System.out.println("Nhập Số Phòng: ");
                                int numberRoomBooked = sc.nextInt();
                                if (!manager.validateRoomNumber(numberRoomBooked)) break; // Kiểm Tra Số Phòng

                                if(manager.getRoomByUser(nameRoomBooked).getStatus()){
                                    System.out.println("Phòng Hiện Tại Đã Được Đặt, Hãy Chọn Phòng Khác!");
                                }else{
                                    User user = new User(
                                            manager.getTotalUser() + 1,
                                            nameUser,
                                            ageUser,
                                            bookedDate,
                                            nameRoomBooked,
                                            numberRoomBooked
                                    );
                                    manager.addUser(user);
                                    manager.getRoomByUser(nameRoomBooked).setInfo(user);
                                    manager.getRoomByUser(nameRoomBooked).setStatus(true);
                                    manager.getRoomByUser(nameRoomBooked).setBooked(LocalDateTime.now());
                                    System.out.println("Đặt Phòng Thành Công!");
                                }
                                break;
                            case 2:
                                System.out.println("Vui Lòng Nhập Tên:");
                                String returnNameUser = sc.next();
                                try{
                                    manager.getUser(returnNameUser).setDateReturn(LocalDateTime.now());
                                    String returnRoomName = manager.getUser(returnNameUser).getNameRoomBooked();
                                    manager.getRoomByUser(returnRoomName).setStatus(false);
                                    manager.getRoomByUser(returnRoomName).setBooked(null);
                                }catch (IndexOutOfBoundsException ex){
                                    System.out.println("Not Founded Name");
                                }
                                break;
                        }
                    }while(thaoTacTrangUser != 0);
                    break;
                default:
                    System.out.println("Thao Tác Không Hợp Lệ!!!");
                    break;
            }

        }while(thaoTacTrangChu != 0);
    }
}
