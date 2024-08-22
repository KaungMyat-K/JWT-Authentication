package com.sq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sq.dao.RoleDao;
import com.sq.dao.UserDao;
import com.sq.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDao userDao) {
        userService.saveUser(userDao);   
        return new ResponseEntity<>("successfully saved user",HttpStatus.CREATED);
    }
    
    @PostMapping("/saveRole")
    public ResponseEntity<String> saveRole(@RequestBody RoleDao roleDao) {
        userService.saveRole(roleDao);
        return new ResponseEntity<>("successfully saved role",HttpStatus.CREATED);
    }
    

}
