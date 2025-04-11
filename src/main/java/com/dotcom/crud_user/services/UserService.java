package com.dotcom.crud_user.services;

import com.dotcom.crud_user.exceptions.UserNotFoundException;
import com.dotcom.crud_user.modes.User;
import com.dotcom.crud_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    @Override
    public User create(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User userDetatils) {
        return userRepository.findById(id)
                .map(user -> {
                    if(!user.getEmail().equals(userDetatils.getEmail())){
                        if(userRepository.existsByEmail(userDetatils.getEmail())){
                            throw new IllegalArgumentException("Email already exists");
                        }
                    }
                    user.setEmail(userDetatils.getEmail());
                    user.setName(userDetatils.getName());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        if(!userRepository.existsById(id)){
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
