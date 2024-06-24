import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        int thaotac = 0;
        System.out.println("----------- MENU -----------");
        System.out.println("1. Xem Danh Sách Phòng");
        System.out.println("2. Xem Chi Tiết Phòng");
        System.out.println("3. Thêm Phòng");
        System.out.println("4. Sửa Phòng");
        System.out.println("5. Xóa Phòng");
        System.out.println("6. Xem Danh Sách Khách Hàng");
        System.out.println("7. Đặt Phòng");
        System.out.println("8. Trả Phòng");
        System.out.println("0. Thoát !!!");

        Manager manager = new Manager();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Chọn Thao Tác Thực Hiện:");

            thaotac = sc.nextInt();

            switch (thaotac){
                case 0:
                    break;
                case 1:
                    manager.getAllRoom();
                    break;
                case 2:
                    if( manager.getTotalRoom() == 0){
                        System.out.println("Danh Sách Phòng Rỗng");
                        break;
                    }
                    System.out.println("Nhập ID Phòng");
                    String id = sc.next();
                    if( !manager.isRoom(id) ){
                        System.out.println("ID Phòng Không Hợp Lệ");
                        break;
                    }
                    manager.printRoom(id);
                    break;
                case 3:
                    if(manager.getTotalRoom() == 5){
                        System.out.println("Số Phòng Đã Đạt 5, Không Thể Thêm!");
                        break;
                    }
                    System.out.println("Nhập Tên Phòng:");
                    String name = sc.next();
                    System.out.println("Nhập Số Phòng:");
                    int number = sc.nextInt();
                    Room room = new Room(manager.getTotalRoom() + 1, name, number);
                    manager.setListRoom(room);
                    System.out.println("Thêm Phòng Thành Công!");
                    break;
                case 4:
                    if( manager.getTotalRoom() == 0){
                        System.out.println("Danh Sách Phòng Rỗng");
                        break;
                    }
                    System.out.println("Nhập ID Phòng: ");
                    String findId = sc.next();
                    if( !manager.isRoom(findId) ){
                        System.out.println("ID Phòng Không Hợp Lệ");
                        break;
                    }
                    System.out.println("Nhập Tên Mới: ");
                    String newName = sc.next();
                    System.out.println("Nhập Số Phòng Mới: ");
                    int newNumberRoom = sc.nextInt();
                    manager.getRoom(findId).setRoomName(newName);
                    manager.getRoom(findId).setRoomNumber(newNumberRoom);
                    break;
                case 5:
                    if( manager.getTotalRoom() == 0){
                        System.out.println("Danh Sách Phòng Rỗng");
                        break;
                    }
                    System.out.println("Nhập ID Phòng: ");
                    String enterId = sc.next();
                    if( !manager.isRoom(enterId) ){
                        System.out.println("ID Phòng Không Hợp Lệ");
                        break;
                    }
                    manager.removeRoom(enterId);
                    break;
                case 6:
                    manager.getAllUser();
                    break;
                case 7:
                    System.out.println("Vui Lòng Nhập Tên: ");
                    String nameUser = sc.next();
                    System.out.println("Vui Lòng Nhập Tuổi: ");
                    int ageUser = sc.nextInt();
                    if( ageUser < 18 ){
                        System.out.println("Tuổi Không Hợp lệ !");
                        break;
                    }
                    System.out.println("Ngày Đặt Phòng: ");
                    int date = sc.nextInt();
                    if( date < LocalDateTime.now().getDayOfMonth() ){
                        System.out.println("Ngày Không Hợp Lệ!");
                        break;
                    }
                    System.out.println("Giờ Đặt Phòng: ");
                    int hour = sc.nextInt();
                    LocalDateTime bookedDate = LocalDateTime.of(
                            LocalDateTime.now().getYear(),
                            LocalDateTime.now().getMonth(),
                            date,
                            hour,
                            0);
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                    String formattedDateTime = bookedDate.format(formatter);
//                    System.out.println("Formatted Date and Time: " + formattedDateTime);
                    System.out.println("Nhập Tên Phòng: ");
                    String bookedName = sc.next();
                    System.out.println("Nhập Số Phòng: ");
                    int bookedNumber = sc.nextInt();
                    if(!manager.matchRoom(bookedName, bookedNumber)){
                        System.out.println("Phòng Không Tồn Tại!");
                    }
                    if(manager.getRoomForUser(bookedName).getRoomStatus()){
                        System.out.println("Phòng Hiện Tại Đã Được Đặt, Hãy Chọn Phòng Khác!");
                    }else{
                        if(!manager.isUser(nameUser)){
                            User user = new User(
                                    manager.getTotalUser() + 1,
                                    nameUser,
                                    ageUser,
                                    bookedDate,
                                    bookedName,
                                    bookedNumber
                            );
                            manager.setListUser(user);
                        }
                        manager.getRoomForUser(bookedName).setRoomStatus(true);
                        System.out.println("Đặt Phòng Thành Công!");
                    }
                    break;
                case 8:
                    System.out.println("Sửa Thông Tin Khách Hàng:");
                    manager.getAllUser();
                    break;
                default:
                    System.out.println("Thao Tác Không Hợp Lệ!!!");
                    break;
            }

        }while(thaotac != 0);
    }
}
