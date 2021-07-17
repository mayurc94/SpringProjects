package com.CovidDaily.Covid19DailyTracker.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static com.CovidDaily.Covid19DailyTracker.helper.Constants.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class VaccineDataService {

	
	private static String COWIN_STATES_URL="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=365&date=07-05-2021";
	private static String COWIN_DISTRICT_URL="https://cdn-api.co-vin.in/api/v2/admin/location/districts/16";
	
	//@PostConstruct
	public void fetchVaccineStates() throws IOException, InterruptedException {
		HttpResponse<String> statesList=commonHttpClientCall(COWIN_STATES_URL);
		
		System.out.println(statesList.body());
		
	}
	
	//@PostConstruct
	public void fetchVaccineDistricts() throws IOException, InterruptedException {
		HttpResponse<String> districtList=commonHttpClientCall(COWIN_DISTRICT_URL);
		
		System.out.println(districtList.body());
		
	}
	
	
	public HttpResponse<String> commonHttpClientCall(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		return httpResponse;
	}
}
