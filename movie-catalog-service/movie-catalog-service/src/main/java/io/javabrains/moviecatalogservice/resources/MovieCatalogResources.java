package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.services.MovieInfo;
import io.javabrains.moviecatalogservice.services.UserRatingInfo;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	 MovieInfo movieInfo;
xj	@Autowired
	 UserRatingInfo userRatingInfo;
	//@Autowired
	//private WebClient.Builder webClientBuilder;
	@RequestMapping("/{userId}")
	//@HystrixCommand(fallbackMethod="getFallbackCatalog")
		public List<CatalogItem> getCatalog(@PathVariable String userId)
		{
		   //WebClient.Builder builder=WebClient.builder();
		   // RestTemplate restTemplate=new RestTemplate();
		    //Movie movie=restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(),Movie.class);
		    /*List<Rating> ratings=Arrays.asList(
		    		new Rating("1234",4),
		    		new Rating("5678",3)
		    		);*/
		    /*return ratings.stream().map(rating->{
		    	Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(),Movie.class);
		    	return new CatalogItem(movie.getName(),"Test",rating.getRating());}).collect(Collectors.toList());*/
		   //get all rated movies Idshttp
    	    //for each movie ID,call movie info service and get details
    	   //put them all together
		   /* return Collections.singletonList(
		    		 new CatalogItem("Transformers","Test",4)
		    		);*/
		  //UserRating ratings=restTemplate.getForObject("http://localhost:8083/ratings/user/"+userId,UserRating.class);
		 // UserRating ratings=restTemplate.getForObject("http://ratings-data-service/ratings/user/"+userId,UserRating.class);
		  //  return ratings.getUserRating().stream().map(rating->{
		    	/*Movie movie=webClientBuilder.build()//webclient
		    	.get()//RequestHeadersUriSpec<capture of ?>
		    	.uri("http://localhost:8082/movies/"+rating.getMovieId())//capture of ?>
		    	.retrieve()//ResponseSpec
		    	.bodyToMono(Movie.class)//Mono<movie>
		    	.block();
		    	return new CatalogItem(movie.getName(),"Test",rating.getRating());}).collect(Collectors.toList());
		    	*/
		    	//Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(),Movie.class);
		    	//Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
		    	//return new CatalogItem(movie.getName(),"Test",rating.getRating());}).collect(Collectors.toList());
		    UserRating userRating=userRatingInfo.getUserRating(userId);
		    return userRating.getUserRating().stream().map(rating->movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
		}
	/*@HystrixCommand(fallbackMethod="getFallbackCatalogItem")
	private CatalogItem getCatalogItem(Rating rating)
	{
		Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
		return new CatalogItem(movie.getName(),"Test",rating.getRating());
	}
	private CatalogItem getFallbackCatalogItem(Rating rating)
	{
		return new CatalogItem("Movie name not found","",rating.getRating());
	}*/
	/*@HystrixCommand(fallbackMethod="getFallbackUserRating")
	private UserRating getUserRating(@PathVariable String userId)
	{
		return restTemplate.getForObject("http://ratings-data-service/ratings/user/"+userId,UserRating.class);	
	}
	private UserRating getFallbackUserRating(@PathVariable String userId)
	{
		UserRating userRating=new UserRating();
		userRating.setUserRating(Arrays.asList(
				  new Rating("0",0)
				));
		return userRating;
	}/*
	/*public List<CatalogItem> getFallbackCatalog(@PathVariable String userId)
	{
		return Arrays.asList(new CatalogItem("No movie","",0));
	}*/
	}

