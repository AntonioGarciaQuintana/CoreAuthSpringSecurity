package com.service.Impl;

import com.entities.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUserName(String username) {
        User user = this.userRepository.getByUserByUserName(username);
        return user;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }
}
