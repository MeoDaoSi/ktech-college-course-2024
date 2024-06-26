package Interface;

import java.time.LocalDateTime;

public interface UserMethod {
    public void showUserDisplay();
    public void addUser();
    public void editUser();
    public void removeUser();
    public String format(LocalDateTime dateTime);
}
