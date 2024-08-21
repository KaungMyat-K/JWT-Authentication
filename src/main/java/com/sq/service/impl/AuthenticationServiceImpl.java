package com.sq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sq.dao.AuthenticationDao;
import com.sq.dto.AuthenticationDto;
import com.sq.repo.UserRepo;
import com.sq.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationDto getUserByEmail(String email) {
        var user = userRepo.findByEmail(email)
                    .orElseThrow(()->new UsernameNotFoundException(email + " not found in DB!!!"));
        AuthenticationDto authenticationDto = new AuthenticationDto(user.getEmail(),user.getPassword(),user.getRoles());
        return authenticationDto;
    }

	@Override
	public AuthenticationDto authenticate(AuthenticationDao authenticationDao) {
		authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authenticationDao.getEmail(),authenticationDao.getPassword())
        );
        return null;
	}
    
}
