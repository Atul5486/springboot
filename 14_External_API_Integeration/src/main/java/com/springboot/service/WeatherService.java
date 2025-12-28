package com.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.entity.WeatherReport;

@Component
@PropertySource("classpath:application.properties")
public class WeatherService {
	
	@Value("${api.key}")
	private String apiKey;
	
	
	@Value("${url.path}")
	private String url;

	
	private RestTemplate restTemplate;
	
	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public WeatherReport getWeather(String city) {
		String finalUrl=url.replace("city", city).replace("API_KEY", apiKey);
		ResponseEntity<WeatherReport> response=restTemplate.exchange(finalUrl, HttpMethod.GET,null,WeatherReport.class);
		WeatherReport body=response.getBody();
		return body;
		
	}
	
}
