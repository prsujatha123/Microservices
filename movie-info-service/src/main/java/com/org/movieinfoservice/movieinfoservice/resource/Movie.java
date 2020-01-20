package com.org.movieinfoservice.movieinfoservice.resource;

public class Movie {
	
	private String name;
	
	
	public Movie(String name, String desc) {
		
		this.name = name;
		this.desc = desc;
	}
	public Movie() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	private String desc;

	
}
