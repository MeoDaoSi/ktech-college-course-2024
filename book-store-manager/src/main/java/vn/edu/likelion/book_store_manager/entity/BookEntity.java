package vn.edu.likelion.book_store_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode( callSuper = false )
@Entity
@Data
@Builder
@Table( name = "tbl_books" )
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity extends BaseEntity {

    @Column( nullable = false )
    private String name;

    @Column( nullable = false )
    private int status;

    @Column( nullable = false )
    private int price;

    @Column( nullable = true )
    private Date release_date;

    @Column( nullable = true )
    private String description;

    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable(
            name = "tbl_stock_out",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<UserEntity> userEntities;

}
