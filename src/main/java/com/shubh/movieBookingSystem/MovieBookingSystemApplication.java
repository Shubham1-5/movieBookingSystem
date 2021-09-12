package com.shubh.movieBookingSystem;

import com.shubh.movieBookingSystem.dao.MovieDao;
import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.services.InitService;
import com.shubh.movieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieBookingSystemApplication {

	/**
	 * We need the logger object
	 * @param args
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingSystemApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		System.out.println("Hello Spring Boot !!! ");

		LOGGER.debug("Writing for debug");
		LOGGER.info("Writing for info");
		LOGGER.warn("Writing for warn");
		LOGGER.error("Writing for error");
	}
	@Bean
	CommandLineRunner init (InitService initService){
		return args -> {
			initService.init();
		};
	}

	/**
	 * This will store the manually created object as a bean in the spring container
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
