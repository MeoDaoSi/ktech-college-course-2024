package vn.edu.likelion.book_store_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.book_store_manager.entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    @Query("SELECT name, price, release_date, count(*) FROM BookEntity b WHERE b.status = 0 GROUP BY b.name, b.price, b.release_date ORDER BY COUNT(*) DESC")
    Iterable<BookEntity> sortedBySale();

    Iterable<BookEntity> findAllByStatus( int status );
    BookEntity findByIdOrName( int id, String name );

}
