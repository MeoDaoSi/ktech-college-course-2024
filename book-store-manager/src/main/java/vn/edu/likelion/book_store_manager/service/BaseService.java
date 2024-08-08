package vn.edu.likelion.book_store_manager.service;

import java.util.Collection;

public interface BaseService<T> {
    T create(T t);
    T update(T t);
    Iterable<T> findAll();
    void delete(int id);
    T findById(int id);
}
