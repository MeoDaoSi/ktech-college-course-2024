package vn.edu.likelion.book_store_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.Collection;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table( name = "tbl_users" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity{

    @Column( unique = true, nullable = false )
    private String username;

    @Column( nullable = false )
    private String password;

//    @ManyToMany( mappedBy = "userEntities", fetch = FetchType.LAZY)
//    private Collection<BookEntity> bookEntities;

}
