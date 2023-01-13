package com.irctc.trainbookingsystem.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClassType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int thirdAcSeats;
	private int secondAcSeats;
	private int firstAcSeats;
	private int sleeperClassSeats;
	private int secondarySittingSeats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getThirdAcSeats() {
		return thirdAcSeats;
	}
	public void setThirdAcSeats(int thirdAcSeats) {
		this.thirdAcSeats = thirdAcSeats;
	}
	public int getSecondAcSeats() {
		return secondAcSeats;
	}
	public void setSecondAcSeats(int secondAcSeats) {
		this.secondAcSeats = secondAcSeats;
	}
	public int getFirstAcSeats() {
		return firstAcSeats;
	}
	public void setFirstAcSeats(int firstAcSeats) {
		this.firstAcSeats = firstAcSeats;
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
