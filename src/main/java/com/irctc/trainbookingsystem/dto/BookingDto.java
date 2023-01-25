package com.irctc.trainbookingsystem.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irctc.trainbookingsystem.entity.Passenger;

public class BookingDto {
	
	private Long pnrNo;

	private Date bookingDate;
	private Date travelDate;
	private Long trainNo;
	private String classType;
	private int userId;
	@JsonIgnore
	private long totalFare;
	
	
	private List<Passenger> passengers;
	
	
	public Long getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(Long pnrNo) {
		this.pnrNo = pnrNo;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Long getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(Long trainNo) {
		this.trainNo = trainNo;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	public long getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(long totalFare) {
		this.totalFare = totalFare;
	}
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
