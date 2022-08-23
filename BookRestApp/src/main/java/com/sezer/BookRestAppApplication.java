package com.sezer;

import com.sezer.user.User;
import com.sezer.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class BookRestAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookRestAppApplication.class, args);
	}

}
