package com.sq.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expriation;

    public String generateJwtToken(String email,String authorization){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expriation))
                .setClaims(getClaimsFromUser(authorization))
                .signWith(getSecretKey())
                .compact();
    }


    private Map<String,String> getClaimsFromUser(String authorization){
        Map<String,String> authorities = new HashMap<>();
        authorities.put("authorization", authorization);
        return authorities;
    }


    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

}
