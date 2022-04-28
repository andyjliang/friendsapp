package com.andyliang.friendsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FriendsApplication {

	@RestController
	class FriendsController {
		@GetMapping("/")
		String hello() {
			return "Bouns a bitch";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FriendsApplication.class, args);
	}
}
