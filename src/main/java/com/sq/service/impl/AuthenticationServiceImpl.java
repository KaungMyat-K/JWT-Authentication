package com.sq.service.impl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sq.dto.AuthenticationDto;
import com.sq.entity.UserEntity;
import com.sq.repo.UserRepo;
import com.sq.security.JwtService;
import com.sq.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;


    @Override
    public UserEntity getUserByEmail(String email) {
        var user = userRepo.findByEmail(email).get();
        return user;
    }

	@Override
	public AuthenticationDto authenticate(Principal principal) {

            var role = getUserByEmail(principal.getName()).getRoles();
            String token = jwtService.generateJwtToken(principal.getName(),role.getName());
            return new AuthenticationDto(principal.getName(), role, token);    
	}
    
}
