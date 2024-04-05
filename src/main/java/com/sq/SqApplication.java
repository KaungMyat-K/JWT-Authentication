package com.sq;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sq.entity.Role;
import com.sq.entity.User;
import com.sq.service.UserService;

@SpringBootApplication
public class SqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_USER"));

			userService.saveUser(new User(null,"mgmg","mg","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"koko","ko","1234",new ArrayList<>()));


			userService.addRoleToUser("mg","ROLE_ADMIN");
			userService.addRoleToUser("ko","ROLE_USER");
		};
	}

}
