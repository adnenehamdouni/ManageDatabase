package com.qugenx.managedatabase.service;

import com.qugenx.managedatabase.entities.UserEntity;
import com.qugenx.managedatabase.repository.UserRepository;
import com.qugenx.managedatabase.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public UserEntity getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        //return user.isPresent() ? user.get() : null;
        return user.orElse(null);
    }
}
