package com.stackroute.graph.service;


import com.stackroute.graph.model.User;
import com.stackroute.graph.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class HomeService {

    private UserRepository userRepository;

    public HomeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveUserToDb(User user) {
        userRepository.save(user);
    }

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
