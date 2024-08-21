package com.sq.service;

import com.sq.dao.AuthenticationDao;
import com.sq.dto.AuthenticationDto;

public interface AuthenticationService {
    
    AuthenticationDto getUserByEmail(String email);

    AuthenticationDto authenticate(AuthenticationDao authenticationDao);
}
