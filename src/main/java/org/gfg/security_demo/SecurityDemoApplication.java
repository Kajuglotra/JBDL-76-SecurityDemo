package org.gfg.security_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class SecurityDemoApplication {

	@Autowired
	private MyUserRepository myUserRepository;


	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		myUserRepository.save(MyUser.builder().
//				username("developer").
//				password("$2a$10$PVeAPzqdZgSuLPBLklttdewPcurZk69Pr5vmf9HVDrx8gAp6PGYY6").
//				accountNonLocked(true).
//				accountNonExpired(true).
//				authorities("DEVELOPER").
//				build());
//
//		myUserRepository.save(MyUser.builder().
//				username("admin").
//				password("$2a$10$mrKQj1.6gSRoFG/srSazrOKwnv7LKIRm5CMMoxh.zmsVSaU3aM08a").
//				accountNonLocked(true).
//				accountNonExpired(true).
//				authorities("ADMIN").
//				build());
//		System.out.println("--------------------------------------------");
//	}
}
