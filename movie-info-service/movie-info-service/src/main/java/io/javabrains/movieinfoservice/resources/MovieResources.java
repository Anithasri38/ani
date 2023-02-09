package io.javabrains.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId)
	{
		return new Movie(movieId,"SitaRamam");
	}
}
