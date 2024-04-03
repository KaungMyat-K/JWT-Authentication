package com.sq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sq.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    
    User findByUsername(String username);
}
