package com.CovidDaily.Covid19DailyTracker.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CovidDaily.Covid19DailyTracker.entity.IndiaModel;
import com.CovidDaily.Covid19DailyTracker.entity.LocationStats;
import com.CovidDaily.Covid19DailyTracker.service.CovidDataService;

@Controller
public class HomeController {

	
	@Autowired
	CovidDataService dataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats=dataService.getCovidStats();
		int totalReportedCases=allStats.stream().mapToInt(stat -> stat.getConfirmed()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		
		return "home";
	}
	
	@GetMapping("/india")
	public String getIndianCovidReport(Model model) throws IOException, InterruptedException, ParseException {
		List<IndiaModel> indianList=dataService.fetchIndianCovidCases();
		IndiaModel indiaModel=indianList.get(33);
		
		int totalConfirmed= Integer.parseInt(indiaModel.getConfirmed());
		
//		int totalConfirmed=indianList.stream().mapToInt(data -> Integer.parseInt(data.getConfirmed())).sum();
		
		model.addAttribute("indianList", indianList);
		model.addAttribute("totalReportedCases", totalConfirmed);
		return "indiaHome";
	}
	
	
}
