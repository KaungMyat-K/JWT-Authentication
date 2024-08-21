package com.sq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sq.repo.RoleRepo;
import com.sq.repo.UserRepo;
import com.sq.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;



	






}
