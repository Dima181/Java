package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;

public interface UserService {
    UserEntity getUser(int id);
    void addUser(UserRequest userRequest);
}
