package com.sq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sq.entity.Role;
import com.sq.entity.User;
import com.sq.repo.RoleRepo;
import com.sq.repo.UserRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private  UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public User saveUser(User user){
        log.info("saved new user {} to DB",user.getName());
        return userRepo.save(user);
    }

    public Role saveRole(Role role){
        log.info("saved new role {} to DB",role.getName());
        return roleRepo.save(role);
    }

    public void addRoleToUser(String username,String roleName){
        log.info("add new role {} to user {}",roleName,username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    public User getUser(String username){
        log.info("fetch user {} ",username);
        return userRepo.findByUsername(username);
    }

    public List<User> getUsers(){
        log.info("fetch all users");
        return userRepo.findAll();
    }

}
