package vn.edu.likelion.book_store_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.book_store_manager.config.Configuration;
import vn.edu.likelion.book_store_manager.entity.BookEntity;
import vn.edu.likelion.book_store_manager.entity.UserEntity;
import vn.edu.likelion.book_store_manager.model.BookDTO;
import vn.edu.likelion.book_store_manager.service.BookService;
import vn.edu.likelion.book_store_manager.utils.AppConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    Configuration configuration;

    // End Point - sortBy, Pagination, sortDir, ...
    @GetMapping
    private Iterable<BookEntity> findAll(
            @RequestParam( value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam( value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam( value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam( value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ){
        return bookService.getAllBook(pageNo, pageSize, sortBy, sortDir);
    }

    @PostMapping
    private BookEntity addBook(@RequestBody BookDTO bookDTO){
        BookEntity bookEntity = BookEntity
                .builder()
                .name(bookDTO.getName())
                .price(bookDTO.getPrice())
                .description(bookDTO.getDescription())
                .release_date(bookDTO.getRelease_date())
                .status(1)
                .build();
        return bookService.create(bookEntity);
    }

    @DeleteMapping("/{id}")
    private void deleteBook(@PathVariable int id){
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    private BookEntity updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO){
        BookEntity bookEntity = bookService.findById(id);
        bookEntity.setName(bookDTO.getName());
        bookEntity.setPrice(bookDTO.getPrice());
        bookEntity.setDescription(bookDTO.getDescription());
        bookEntity.setStatus(bookDTO.getStatus());
        bookEntity.setRelease_date(bookDTO.getRelease_date());
        return bookService.update(bookEntity);
    }

    @GetMapping("/{id}")
    private BookEntity getDetailBook(@PathVariable int id){
        return bookService.findById(id);
    }

    @PatchMapping("/{id}")
    private String sellBook(@PathVariable int id){

        // Check Login
        if(configuration.getUserEntity() == null){
            return "Please login !";
        }

        BookEntity bookEntity = bookService.findById(id);

        // Check Status
        if( bookEntity.getStatus() == 0 ){
            return "Out Of Stock!";
        }

        bookEntity.setStatus(0);
        ArrayList<UserEntity> userList = new ArrayList<>();
        userList.add(configuration.getUserEntity());
        bookEntity.setUserEntities(userList);
        bookService.update(bookEntity);
        return "Sell Book Success!";
    }

    @GetMapping("/sorted/{sortedType}")
    private Iterable<BookEntity> sortedByPrice(@PathVariable String sortedType){
        if( sortedType.equals("price") ){
            return bookService.sortedByPrice();
        }else if ( sortedType.equals("sold") ){
            return bookService.sortedBySale();
        }
        return null;
    }

    @GetMapping("/getAllBySold")
    private Iterable<BookEntity> getAllBySold(){
        return bookService.getAllBySold();
    }

    @PostMapping("/search")
    private BookEntity search(@RequestBody BookDTO bookDTO){
        return bookService.findByIdOrName(bookDTO.getId(), bookDTO.getName());
    }

    @GetMapping("/getByDate")
    private Iterable<BookEntity> findByDate(
            @RequestParam( value = "startDate" ) @DateTimeFormat( pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam( value = "endDate" ) @DateTimeFormat( pattern = "yyyy-mm-dd") Date endDate
    ){
        return bookService.findByDate(startDate, endDate);
    }

}
