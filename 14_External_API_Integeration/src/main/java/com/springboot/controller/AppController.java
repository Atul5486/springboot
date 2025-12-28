package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.WeatherReport;
import com.springboot.service.WeatherService;

@RestController
public class AppController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/")
	public String index(){
		return "Hello this is index page";
	}
	
	@GetMapping("/weather")
	public WeatherReport getWeatherDetails(@RequestParam String city){
		return weatherService.getWeather(city);
	}
	
}
