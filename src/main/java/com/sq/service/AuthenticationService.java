package com.sq.service;

import java.security.Principal;

import com.sq.dto.AuthenticationDto;
import com.sq.entity.UserEntity;

public interface AuthenticationService {
    
    UserEntity getUserByEmail(String email);

    AuthenticationDto authenticate(Principal principal);
}
