package com.irctc.trainbookingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(
	        name = "pnrNo-sequence-generator",
	        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	        parameters = {
	                @Parameter(name = "sequence_name", value = "user_sequence"),
	                @Parameter(name = "initial_value", value = "971401300"),
	                @Parameter(name = "increment_size", value = "2")
	        }
	)
	@GeneratedValue(generator = "pnrNo-sequence-generator")
	@JsonIgnore
	private Long pnrNo;
	
	private Date bookingDate;
	private Date travelDate;
	private Long trainNo;
	private String classType;
	private int userId;
	
	private long totalFare;
	
	@OneToMany(targetEntity = Passenger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_passengers_pnrNo", referencedColumnName = "pnrNo")
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
	
	

}
