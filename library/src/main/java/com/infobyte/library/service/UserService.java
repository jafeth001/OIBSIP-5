package com.infobyte.library.service;

import com.infobyte.library.module.User;
import com.infobyte.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

}
