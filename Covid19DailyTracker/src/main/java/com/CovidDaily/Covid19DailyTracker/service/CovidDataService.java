package com.CovidDaily.Covid19DailyTracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;

import com.CovidDaily.Covid19DailyTracker.entity.IndiaModel;
import com.CovidDaily.Covid19DailyTracker.entity.LocationModel;
import com.CovidDaily.Covid19DailyTracker.entity.StateEntity;
import com.CovidDaily.Covid19DailyTracker.helper.IndiaModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.CovidDaily.Covid19DailyTracker.helper.Constants.*;

@Service
public class CovidDataService {

	private List<LocationModel> covidStats = new ArrayList<>();

	private List<IndiaModel> indianList = new ArrayList<>();

	@Autowired
	private IndiaModelMapper modelMapper;

	public List<LocationModel> getCovidStats() {
		return covidStats;
	}

	public List<IndiaModel> getIndianList() {
		return indianList;
	}

	//@PostConstruct
	@Scheduled(cron = "* * * * * *")
	public List<LocationModel> fetchVirusData() throws IOException, InterruptedException {
		List<LocationModel> locationList = new ArrayList<>();

		HttpResponse<String> httpResponse = commonHttpClientCall(COVID_FETCH_URL);

		StringReader csvReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
		for (CSVRecord record : records) {
			LocationModel stats = new LocationModel();
			stats.setState(record.get("Province_State"));
			stats.setCountry(record.get("Country_Region"));
			stats.setConfirmed(Integer.parseInt(record.get("Confirmed")));
			stats.setActive((record.get("Active")));
			stats.setDeaths(Integer.parseInt(record.get("Deaths")));
			stats.setRecovered(record.get("Recovered"));

//			System.out.println(stats);
			locationList.add(stats);
		}

		return this.covidStats = locationList;

	}

	// @PostConstruct
	public List<IndiaModel> fetchIndianCovidCases() {

		List<IndiaModel> indiaModelList = new ArrayList<>();
		try {
			HttpResponse<String> response = commonHttpClientCall(COVID_INDIA_URL);

			indiaModelList = modelMapper.indiaModelHelper(response);

			this.indianList = modelMapper.filterByDate(indiaModelList);
		} catch (Exception e) {
			e.getMessage();
		}

		return indianList;
	}

//	@PostConstruct
	public List<StateEntity> getStatesFromCowin() {
		String urlString = COWIN_STATES_URL;
		List<StateEntity> statesList = new ArrayList<>();

		try {
			HttpResponse<String> response = commonHttpClientCallForCowin(urlString);

			JSONObject root = new JSONObject(response.body());
			JSONArray stateArray = root.getJSONArray("states");

			for (int i = 0; i < stateArray.length(); i++) {
				JSONObject stateObject = stateArray.getJSONObject(i);

				StateEntity state = new StateEntity();
				state.setState_id(stateObject.getInt("state_id"));
				state.setState_name(stateObject.getString("state_name"));

				statesList.add(state);

				System.out.println(state);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return statesList;
	}

	public String getAppointment() throws IOException, InterruptedException {
		String urString = COWIN_APPT_URL;

		HttpResponse<String> response = commonHttpClientCallForCowin(urString);

		System.out.println(response.body());
		return response.toString();
	}

//	@PostConstruct
	public String findByPincode(String pincode, String date) throws IOException, InterruptedException {

		String urlString = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=" + pincode
				+ "&date=" + date;

		HttpResponse<String> httpResponse = commonHttpClientCallForCowin(urlString);

		System.out.println(httpResponse.body());
		return httpResponse.body();

	}

	public HttpResponse<String> commonHttpClientCall(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		return httpResponse;
	}

	public HttpResponse<String> commonHttpClientCallForCowin(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).setHeader("user-agent", USER_AGENT)
				.build();

		HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		return httpResponse;
	}

}
