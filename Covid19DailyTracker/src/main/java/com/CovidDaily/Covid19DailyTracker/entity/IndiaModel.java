package com.CovidDaily.Covid19DailyTracker.entity;

public class IndiaModel {

	private String date;
	private String state;
	private String confirmed;
	private String recovered;
	private String deceased;
	private String tested;

	public String getTested() {
		return tested;
	}

	public void setTested(String tested) {
		this.tested = tested;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getDeceased() {
		return deceased;
	}

	public void setDeceased(String deceased) {
		this.deceased = deceased;
	}

	@Override
	public String toString() {
		return "IndiaModel [date=" + date + ", state=" + state + ", confirmed=" + confirmed + ", recovered=" + recovered
				+ ", deceased=" + deceased + ", tested=" + tested + "]";
	}

}
