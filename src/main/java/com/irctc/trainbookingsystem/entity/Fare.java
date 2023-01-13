package com.irctc.trainbookingsystem.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fare implements Serializable {

	private static final long serialVersionUID = 1L;
@Id	
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int id;
private int thirdAcFare;
private int secondAcFare;
private int firstAcFare;
private int sleeperClassFare;
private int secondarySittingFare;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getThirdAcFare() {
	return thirdAcFare;
}
public void setThirdAcFare(int thirdAcFare) {
	this.thirdAcFare = thirdAcFare;
}
public int getSecondAcFare() {
	return secondAcFare;
}
public void setSecondAcFare(int secondAcFare) {
	this.secondAcFare = secondAcFare;
}
public int getFirstAcFare() {
	return firstAcFare;
}
public void setFirstAcFare(int firstAcFare) {
	this.firstAcFare = firstAcFare;
}
public int getSleeperClassFare() {
	return sleeperClassFare;
}
public void setSleeperClassFare(int sleeperClassFare) {
	this.sleeperClassFare = sleeperClassFare;
}
public int getSecondarySittingFare() {
	return secondarySittingFare;
}
public void setSecondarySittingFare(int secondarySittingFare) {
	this.secondarySittingFare = secondarySittingFare;
}
}
