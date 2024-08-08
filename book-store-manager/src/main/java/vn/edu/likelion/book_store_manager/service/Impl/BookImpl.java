package vn.edu.likelion.book_store_manager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.likelion.book_store_manager.entity.BookEntity;
import vn.edu.likelion.book_store_manager.repository.BookRepo;
import vn.edu.likelion.book_store_manager.service.BookService;
import vn.edu.likelion.book_store_manager.utils.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    Util util;

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookRepo.save(bookEntity);
    }

    @Override
    public BookEntity update(BookEntity bookEntity) {
        return bookRepo.save(bookEntity);
    }

    @Override
    public Iterable<BookEntity> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public void delete(int id) {
        bookRepo.deleteById(id);
    }

    @Override
    public BookEntity findById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not founded!"));
    }

    @Override
    public Iterable<BookEntity> sortedByPrice() {
        ArrayList<BookEntity> bookList = (ArrayList<BookEntity>) bookRepo.findAll();
        return util.sortByPrice(bookList);
    }

    @Override
    public Iterable<BookEntity> sortedBySale() {
        return bookRepo.sortedBySale();
    }

    @Override
    public Iterable<BookEntity> getAllBySold() {
        return bookRepo.findAllByStatus(0);
    }

    @Override
    public BookEntity findByIdOrName(int id, String name) {
        return bookRepo.findByIdOrName(id, name);
    }

    @Override
    public Iterable<BookEntity> getAllBook(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return bookRepo.findAll(pageable).getContent();
    }

    @Override
    public Iterable<BookEntity> findByDate(Date startDate, Date endDate) {
        List<BookEntity> bookList1 = bookRepo.findAll();
        List<BookEntity> bookList2 = new ArrayList<>();
        for( BookEntity book : bookList1 ){
            System.out.println(book.getCreatedAt().getTime());
            System.out.println(endDate.getTime());
            if( book.getCreatedAt().after(startDate) && book.getCreatedAt().before(endDate) ){
                bookList2.add(book);
            }
        }

        return bookList2;
    }
}
