package com.sq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sq.entity.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,Long> {
    
    RoleEntity findByName(String name);
}
