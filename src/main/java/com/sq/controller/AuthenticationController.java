package com.sq.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sq.dto.AuthenticationDto;
import com.sq.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> postMethodName(Principal principal) {
        AuthenticationDto authenticationDto = authenticationService.authenticate(principal);
        return new ResponseEntity<>(authenticationDto,HttpStatus.OK);
    }
    

    
}
