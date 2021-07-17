package com.CovidDaily.Covid19DailyTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class Covid19DailyTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19DailyTrackerApplication.class, args);
		System.out.println("Welcome to Covid19 Daily Tracker");
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
