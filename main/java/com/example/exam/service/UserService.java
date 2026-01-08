package com.example.exam.service;

import com.example.exam.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User findByUsername(String username);
}
