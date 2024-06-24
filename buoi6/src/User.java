import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int STT;
    private String name;
    private int age;
    private LocalDateTime dateBooked;
    private String nameRoomBooked;
    private int numberRoomBooked;
    private LocalDateTime returnDate;

    public User(
            int STT,
            String name,
            int age,
            LocalDateTime date,
            String roomName,
            int roomNumber
    ){
        this.STT = STT;
        this.name = name;
        this.age = age;
        this.dateBooked = date;
        this.nameRoomBooked = roomName;
        this.numberRoomBooked = roomNumber;
    }

    public int getSTT() {
        return STT;
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

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
