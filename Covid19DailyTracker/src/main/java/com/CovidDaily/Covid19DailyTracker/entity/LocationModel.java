package com.CovidDaily.Covid19DailyTracker.entity;

public class LocationModel {

	private String state;
	private String country;
	private int confirmed;
	private String active;
	private int deaths;
	private String recovered;
	


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	


	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", confirmed=" + confirmed + ", active="
				+ active + ", deaths=" + deaths + ", recovered=" + recovered + "]";
	}


	
	

}
