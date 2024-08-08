package vn.edu.likelion.book_store_manager.service;

import vn.edu.likelion.book_store_manager.entity.UserEntity;

public interface UserService extends BaseService<UserEntity>{
    UserEntity login(String username, String password);
}
