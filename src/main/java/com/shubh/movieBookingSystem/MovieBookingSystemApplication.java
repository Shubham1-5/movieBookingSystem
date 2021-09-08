package com.shubh.movieBookingSystem;

import com.shubh.movieBookingSystem.dao.MovieDao;
import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.services.InitService;
import com.shubh.movieBookingSystem.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		System.out.println("Hello Spring Boot !!! ");
	}
	@Bean
	CommandLineRunner init (InitService initService){
		return args -> {
			initService.init();
		};
	}

}
