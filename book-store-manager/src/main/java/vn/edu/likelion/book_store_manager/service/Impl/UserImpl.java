package vn.edu.likelion.book_store_manager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.book_store_manager.entity.UserEntity;
import vn.edu.likelion.book_store_manager.repository.UserRepo;
import vn.edu.likelion.book_store_manager.service.UserService;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity login(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return null;
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public UserEntity findById(int id) {
        return null;
    }
}
