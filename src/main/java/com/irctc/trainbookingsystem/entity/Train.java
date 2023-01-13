package com.irctc.trainbookingsystem.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Train implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private long trainNo;
	private String trainName;
	/*
	 * @OneToOne(targetEntity = ClassType.class, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "classType_id", referencedColumnName = "id") private
	 * ClassType classsType;
	 */
	@OneToOne(targetEntity = Fare.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Fare_id", referencedColumnName = "id")
	private Fare farelist;
	@ManyToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "departure_id", referencedColumnName = "id")
	private Location departureLocation;
	@ManyToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "arrival_id", referencedColumnName = "id")
	private Location arrivalLocation;
	@Temporal(TemporalType.DATE)
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
