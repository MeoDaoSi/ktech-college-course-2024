package vn.edu.likelion.book_store_manager.service;

import vn.edu.likelion.book_store_manager.entity.BookEntity;

import java.awt.print.Pageable;
import java.util.Date;

public interface BookService extends BaseService<BookEntity>{
    Iterable<BookEntity> sortedByPrice();
    Iterable<BookEntity> sortedBySale();
    Iterable<BookEntity> getAllBySold();
    BookEntity findByIdOrName(int id, String name);
    Iterable<BookEntity> getAllBook(int pageNo, int pageSize, String sortBy, String sortDir);
    Iterable<BookEntity> findByDate(Date startDate, Date endDate);
}
