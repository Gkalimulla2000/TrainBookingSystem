package com.irctc.trainbookingsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Train implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long trainNo;
	private String trainName;
	@OneToOne(targetEntity = Fare.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fare_id", referencedColumnName = "id")
	private Fare farelist;
	@ManyToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "departure_id", referencedColumnName = "id")
	private Location departureLocation;
	@ManyToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "arrival_id", referencedColumnName = "id")
	private Location arrivalLocation;
	@Temporal(TemporalType.DATE)
	private Date arraivalDate;
	private int firstACSeats;
	private int secondACSeats;
	private int thirdACSeats;
	private int sleeperClassSeats;
	private int secondarySittingSeats;
	public Long getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(Long trainNo) {
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
