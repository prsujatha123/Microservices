package com.org.movieratingservice.movieratingservice.resource;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
				return new Rating(movieId, 4);
		
		
	}
	
	@RequestMapping("user/{userId}")
	
	public UserRating getRatings(@PathVariable("userId") String userId){
		List<Rating> rating=Arrays.asList(
				new Rating("12345", 4),
				new Rating("56789",5)
				);
		
		UserRating userRating=new UserRating();
		userRating.setUserRating(rating);
		return userRating;
	}

}
