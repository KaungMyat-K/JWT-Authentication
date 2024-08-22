package com.sq.security;

import java.util.ArrayList;
import java.util.Collection;

import com.sq.entity.UserEntity;
import com.sq.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AuthenticationService AuthenticationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = AuthenticationService.getUserByEmail(username);
        if(user == null){
            log.info("user not found!!!");
            throw new UsernameNotFoundException(username+" not found in DB");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRoles().getName()));
        return new User(user.getEmail(),user.getPassword(),authorities);
    }
     
}
