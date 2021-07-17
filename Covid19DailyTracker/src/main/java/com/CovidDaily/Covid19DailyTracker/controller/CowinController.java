package com.CovidDaily.Covid19DailyTracker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CovidDaily.Covid19DailyTracker.entity.StateEntity;
import com.CovidDaily.Covid19DailyTracker.service.CovidDataService;

@RestController
public class CowinController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CovidDataService service;

	@GetMapping("/cowin")
	public List<StateEntity> getCowinstates() throws IOException, InterruptedException {

		List<StateEntity> response = service.getStatesFromCowin();

		return response;
	}

	@GetMapping("/findByPin")
	public String getVaccineByPinCode(@RequestParam(name = "pincode") String pincode,
			@RequestParam(name = "date") String date) throws IOException, InterruptedException {

		return service.findByPincode(pincode, date);
	}

}
