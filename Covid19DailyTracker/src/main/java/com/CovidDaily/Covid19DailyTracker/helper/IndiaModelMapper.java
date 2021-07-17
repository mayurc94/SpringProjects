package com.CovidDaily.Covid19DailyTracker.helper;

import java.io.IOException;
import java.io.StringReader;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.CovidDaily.Covid19DailyTracker.entity.IndiaModel;

@Component
public class IndiaModelMapper {

	public List<IndiaModel> indiaModelHelper(HttpResponse<String> responseObj) throws IOException {
		List<IndiaModel> indiaModelList = new ArrayList<>();

		StringReader reader = new StringReader(responseObj.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		for (CSVRecord record : records) {
			IndiaModel indiaModel = new IndiaModel();

			indiaModel.setDate(record.get("Date"));
			indiaModel.setConfirmed(record.get("Confirmed"));
			indiaModel.setState(record.get("State"));
			indiaModel.setDeceased(record.get("Deceased"));
			indiaModel.setRecovered(record.get("Recovered"));
			indiaModel.setTested(record.get("Tested"));

			indiaModelList.add(indiaModel);
			// System.out.println(indiaModel);
		}

		return indiaModelList;
	}

	public List<IndiaModel> filterByDate(List<IndiaModel> list) throws ParseException {

		List<IndiaModel> filteredList = new ArrayList<>();

		for (Iterator<IndiaModel> iterator = list.iterator(); iterator.hasNext();) {
			IndiaModel indiaModel = (IndiaModel) iterator.next();

			SimpleDateFormat dateToday = new SimpleDateFormat("yyyy-MM-dd");
			Long dateTodayLong = System.currentTimeMillis();

			Date todayDate = new Date(dateTodayLong);

			if (indiaModel.getDate().equals(dateToday.format(todayDate))) {
				filteredList.add(indiaModel);
			}

		}
		
		return filteredList;

	}

}
