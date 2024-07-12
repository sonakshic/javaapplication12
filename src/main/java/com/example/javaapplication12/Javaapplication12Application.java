package com.example.javaapplication12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
//@SpringBootApplication
@ComponentScan(basePackages = { "com.example.*" })
@EnableJpaRepositories(basePackages = "com.example.javaresposity")
@EnableAutoConfiguration
@EntityScan("com.example.*")  
  
public class Javaapplication12Application {

	public static void main(String[] args) {
		SpringApplication.run(Javaapplication12Application.class, args);
	}

}
