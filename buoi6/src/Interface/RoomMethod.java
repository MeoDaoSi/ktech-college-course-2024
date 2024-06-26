package Interface;

import java.time.LocalDateTime;

public interface RoomMethod {
    public void showRoomDisplay();
    public void addRoom();
    public void editRoom();
    public void removeRoom();
    public String format(LocalDateTime dateTime);
}
