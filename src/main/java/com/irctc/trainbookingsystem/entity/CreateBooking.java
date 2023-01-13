package com.irctc.trainbookingsystem.entity;

import java.util.List;

public class CreateBooking {
private Booking booking;
private List<Passenger> passengers;
public Booking getBooking() {
	return booking;
}
public void setBooking(Booking booking) {
	this.booking = booking;
}
public List<Passenger> getPassengers() {
	return passengers;
}
public void setPassengers(List<Passenger> passengers) {
	this.passengers = passengers;
}
}
