package com.qugenx.managedatabase.controller;

import com.qugenx.managedatabase.entities.UserEntity;
import com.qugenx.managedatabase.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(IndexController.class);


    @PostMapping("/userByRequestBody")
    public ResponseEntity<Object> showUserByRequestBody(@Valid @RequestBody Long id) {

        logger.info("id = "+id);
        UserEntity user = userService.getUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user Found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/userByFirstNameRequestParam")
    public ResponseEntity<Object> showUserByRequestParam(@Valid @RequestParam(name = "name") String firstName) {
        logger.info("firstname = "+firstName);
        UserEntity user = userService.getUserByFirstName(firstName);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user Found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/userByUserRequestBody")
    public ResponseEntity<Object> showUserByRequestParam(@Valid @RequestBody UserEntity userEntity) {

        UserEntity user = userService.getUserByFirstName(userEntity.getFirstName());

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user Found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> retrieveUsers(@Valid @PathVariable String userId) {
        logger.info("userId = "+userId);
        UserEntity user = userService.getUserById(Long.parseLong(userId));

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user Found", HttpStatus.NOT_FOUND);
        }
    }

}
