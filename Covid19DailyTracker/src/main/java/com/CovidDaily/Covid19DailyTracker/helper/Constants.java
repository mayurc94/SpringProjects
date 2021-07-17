package com.CovidDaily.Covid19DailyTracker.helper;


public final class Constants {

	
	public final static String COVID_FETCH_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/06-25-2021.csv";

	public final static String COWIN_APPT_URL="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=110001&date=03-07-2021";
	
	public final static String COWIN_STATES_URL="https://cdn-api.co-vin.in/api/v2/admin/location/states";
	
	public final static String COVID_INDIA_URL = "https://api.covid19india.org/csv/latest/states.csv";
	
	public final static String COWIN_VACCINE_BY_PINCODE = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=590010&date=08-07-2021";
	
	public final static String USER_AGENT="Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36";
}
