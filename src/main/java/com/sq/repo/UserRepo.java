package com.sq.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sq.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    
    Optional<UserEntity> findByEmail(String email);
}
