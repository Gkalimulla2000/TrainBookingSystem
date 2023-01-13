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
	private int FirstACSeats;
	private int SecondACSeats;
	private int ThirdACSeats;
	private int SleeperClassSeats;
	private int SecondarySittingSeats;
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
		return FirstACSeats;
	}
	public void setFirstACSeats(int firstACSeats) {
		FirstACSeats = firstACSeats;
	}
	public int getSecondACSeats() {
		return SecondACSeats;
	}
	public void setSecondACSeats(int secondACSeats) {
		SecondACSeats = secondACSeats;
	}
	public int getThirdACSeats() {
		return ThirdACSeats;
	}
	public void setThirdACSeats(int thirdACSeats) {
		ThirdACSeats = thirdACSeats;
	}
	public int getSleeperClassSeats() {
		return SleeperClassSeats;
	}
	public void setSleeperClassSeats(int sleeperClassSeats) {
		SleeperClassSeats = sleeperClassSeats;
	}
	public int getSecondarySittingSeats() {
		return SecondarySittingSeats;
	}
	public void setSecondarySittingSeats(int secondarySittingSeats) {
		SecondarySittingSeats = secondarySittingSeats;
	}
	
	
}
