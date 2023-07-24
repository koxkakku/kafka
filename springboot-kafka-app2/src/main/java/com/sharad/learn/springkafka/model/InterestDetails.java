package com.sharad.learn.springkafka.model;

public class InterestDetails{
	/**
	 * 
	 */
	private double principal;
	private double rateOfInterest;
	private double time;
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "InterestDetails [principal=" + principal + ", rateOfInterest=" + rateOfInterest + ", time=" + time
				+ "]";
	}

	
}
