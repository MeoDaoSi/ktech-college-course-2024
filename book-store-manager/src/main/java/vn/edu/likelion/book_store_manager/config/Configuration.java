package vn.edu.likelion.book_store_manager.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import vn.edu.likelion.book_store_manager.entity.UserEntity;

@Component
@Data
public class Configuration {

    public static final int page_number = 5;
    private UserEntity userEntity;

}
