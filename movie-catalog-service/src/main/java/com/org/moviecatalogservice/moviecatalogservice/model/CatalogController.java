package com.org.moviecatalogservice.moviecatalogservice.model;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating rating=restTemplate.getForObject("http://movie-rating-service/rating/user/"+userId, UserRating.class );
		
	      List<CatalogItem> list= rating.getUserRating().stream().map(
	    	  rat->{
	    		   Movie movie= restTemplate.getForObject("http://movie-info-service/movieinfo/"+rat.getMovieId(),Movie.class );
	    		  
	    		 return  new CatalogItem(movie.getName(),movie.getDesc(),rat.getRating());
	    	  })
	    		  .collect(Collectors.toList());	
	     
		return list;
		
		
	}
}
