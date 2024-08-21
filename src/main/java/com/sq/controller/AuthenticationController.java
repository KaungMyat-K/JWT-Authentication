package com.sq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sq.dao.AuthenticationDao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @PostMapping("/login")
    public ResponseEntity<String> postMethodName(@RequestBody AuthenticationDao authenticationDao) {
        
        
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    

    
}
