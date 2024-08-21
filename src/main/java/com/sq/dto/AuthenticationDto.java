package com.sq.dto;

import java.util.*;

import com.sq.entity.RoleEntity;

public record AuthenticationDto(String email,String password,List<RoleEntity> roles) {
    
}
