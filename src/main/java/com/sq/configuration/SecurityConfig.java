package com.sq.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sq.security.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http
        .csrf(csrf->csrf.disable())
        .userDetailsService(userDetailServiceImpl)
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(request->{
            request.requestMatchers("/users/**").permitAll()
            .anyRequest().authenticated();
        })
        .httpBasic(Customizer.withDefaults());   
        return http.build();
    }

    @Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}



}
