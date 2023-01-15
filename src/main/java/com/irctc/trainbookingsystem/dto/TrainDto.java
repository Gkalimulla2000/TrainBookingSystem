package com.irctc.trainbookingsystem.dto;

import java.util.Date;

import com.irctc.trainbookingsystem.entity.Fare;
import com.irctc.trainbookingsystem.entity.Location;

public class TrainDto {
	private long trainNo;
	private String trainName;
	private Fare farelist;
	private Location departureLocation;
	private Location arrivalLocation;
	private Date arraivalDate;
	private int firstACSeats;
	private int secondACSeats;
	private int thirdACSeats;
	private int sleeperClassSeats;
	private int secondarySittingSeats;
	public long getTrainNo() {
		return trainNo;	
	}
	public void setTrainNo(long trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	public Fare getFarelist() {
		return farelist;
	}
	public void setFarelist(Fare farelist) {
		this.farelist = farelist;
	}
	public Location getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(Location departureLocation) {
		this.departureLocation = departureLocation;
	}
	public Location getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(Location arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public Date getArraivalDate() {
		return arraivalDate;
	}
	public void setArraivalDate(Date arraivalDate) {
		this.arraivalDate = arraivalDate;
	}
	public int getFirstACSeats() {
		return firstACSeats;
	}
	public void setFirstACSeats(int firstACSeats) {
		this.firstACSeats = firstACSeats;
	}
	public int getSecondACSeats() {
		return secondACSeats;
	}
	public void setSecondACSeats(int secondACSeats) {
		this.secondACSeats = secondACSeats;
	}
	public int getThirdACSeats() {
		return thirdACSeats;
	}
	public void setThirdACSeats(int thirdACSeats) {
		this.thirdACSeats = thirdACSeats;
	}
	public int getSleeperClassSeats() {
		return sleeperClassSeats;
	}
	public void setSleeperClassSeats(int sleeperClassSeats) {
		this.sleeperClassSeats = sleeperClassSeats;
	}
	public int getSecondarySittingSeats() {
		return secondarySittingSeats;
	}
	public void setSecondarySittingSeats(int secondarySittingSeats) {
		this.secondarySittingSeats = secondarySittingSeats;
	}
	
	
}
