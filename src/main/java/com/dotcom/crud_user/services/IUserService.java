package com.dotcom.crud_user.services;
import com.dotcom.crud_user.modes.User;
import java.util.List;
import java.util.Optional;



public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
}
