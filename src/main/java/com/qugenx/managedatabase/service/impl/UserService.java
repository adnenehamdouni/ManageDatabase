package com.qugenx.managedatabase.service.impl;


import com.qugenx.managedatabase.entities.UserEntity;

public interface UserService {
    UserEntity getUserByFirstName(String firstName);
    UserEntity getUserById(Long id);
}
