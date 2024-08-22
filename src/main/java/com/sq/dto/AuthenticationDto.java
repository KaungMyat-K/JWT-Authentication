package com.sq.dto;


import com.sq.entity.RoleEntity;

public record AuthenticationDto(String email,RoleEntity roles,String token) {
    
}
