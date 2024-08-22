package com.sq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sq.dao.RoleDao;
import com.sq.dao.UserDao;
import com.sq.entity.RoleEntity;
import com.sq.entity.UserEntity;
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

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void saveUser(UserDao userDao) {
        var user = new UserEntity();
        var role = roleRepo.findByName(userDao.getRoles());
        user.setEmail(userDao.getEmail());
        user.setUsername(userDao.getUsername());
        user.setPassword(encoder.encode(userDao.getPassword()));
        user.setRoles(role);
        userRepo.save(user);
    }

    @Override
    public void saveRole(RoleDao roleDao) {
        var role = new RoleEntity();
        role.setName(roleDao.getName());
        roleRepo.save(role);
    }



	






}
