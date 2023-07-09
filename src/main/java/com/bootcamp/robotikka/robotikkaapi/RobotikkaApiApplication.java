package com.bootcamp.robotikka.robotikkaapi;

import com.bootcamp.robotikka.robotikkaapi.entity.UserRole;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRoleRepo;
import com.bootcamp.robotikka.robotikkaapi.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobotikkaApiApplication implements CommandLineRunner {
    @Autowired
	private UserRoleService userRoleService;

	public static void main(String[] args) {
		SpringApplication.run(RobotikkaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
         userRoleService.initializeRoles();
	}
}
