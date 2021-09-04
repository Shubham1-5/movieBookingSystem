package com.shubh.movieBookingSystem;

import com.shubh.movieBookingSystem.dao.MovieDao;
import com.shubh.movieBookingSystem.entities.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);
		MovieDao movieDao = ctx.getBean(MovieDao.class);
		System.out.println(movieDao);

		/**
		 * I should be able to save the entity
		 */

		System.out.println("---- Creating Movie Object Cool ----");
		Movie movie = new Movie();
		movie.setMovieName("Kesari");
		movie.setMovieDescription("Very nice movie");
		movie.setReleaseDate(LocalDateTime.of(2019,4,27,5,30));
		movie.setDuration(150);
		movie.setCoverPhotoUrl("cover-photo-url");
		movie.setTrailerUrl("trailer-url");

		System.out.println("Movie object before storage : "+movie);

		Movie movie1 = new Movie();

		/**
		 * Here everything is written except movieId, because that would be created
		 * by db internally (we mentioned it in Movie.class)
		 * Even if we write move.setMovieId(4) - JPA doesn't care because it will
		 * create automatically
		 */

		movie1.setMovieName("Mission Mangal");
		movie1.setMovieDescription("Very nice movie again");
		movie1.setReleaseDate(LocalDateTime.of(2019,3,25,5,30));
		movie1.setDuration(150);
		movie1.setCoverPhotoUrl("cover-photo-url");
		movie1.setTrailerUrl("trailer-url");

		System.out.println("#### Going to save now in DB ####");
		Movie savedObject = movieDao.save(movie);
		Movie savedObject1 = movieDao.save(movie1);
		System.out.println("Saved object : "+savedObject);
		System.out.println("Saved object2 : "+savedObject1);

		/**
		 * I should be able to find the movie I'm interested in
		 * Here findById returns Optional (to avoid null pointer exception)
		 */

		Movie searchedMovie = movieDao.findById(2).get();
		System.out.println("Searched Movie : "+searchedMovie);

		movie.setMovieDescription("Updated description");
		movieDao.save(movie);

		/**
		 * I want to delete the movie
		 */

		movieDao.delete(searchedMovie);
	}

}
