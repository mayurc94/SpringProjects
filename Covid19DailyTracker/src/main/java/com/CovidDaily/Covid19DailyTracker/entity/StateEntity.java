package com.CovidDaily.Covid19DailyTracker.entity;

public class StateEntity {

	private int state_id;
	private String state_name;
	
	
	public StateEntity() {
		super();
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	@Override
	public String toString() {
		return "StateEntity [state_id=" + state_id + ", state_name=" + state_name + "]";
	}
	
	
	
	
}
