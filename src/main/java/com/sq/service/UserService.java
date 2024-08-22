package com.sq.service;

import com.sq.dao.RoleDao;
import com.sq.dao.UserDao;

public interface UserService {
    
    void saveUser(UserDao userDao);
    void saveRole(RoleDao roleDao);
}
