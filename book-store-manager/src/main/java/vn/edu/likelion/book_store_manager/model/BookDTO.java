package vn.edu.likelion.book_store_manager.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import vn.edu.likelion.book_store_manager.entity.UserEntity;

import java.util.Collection;
import java.util.Date;

@Data
public class BookDTO {
    private int id;
    private String name;
    private int status;
    private int price;
    private Date release_date;
    private String description;
}
