package com.irctc.trainbookingsystem.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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
	private long pnrNo;
	
	private Date bookingDate;
	private Date travelDate;
	private long trainNo;
	private String classType;
	
	public long getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(long pnrNo) {
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
	public long getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(long trainNo) {
		this.trainNo = trainNo;
	}
	public String getClassType() {
		return classType;
	}
	
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	
	
	

}
