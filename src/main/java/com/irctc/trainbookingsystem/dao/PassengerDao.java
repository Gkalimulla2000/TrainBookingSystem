package com.irctc.trainbookingsystem.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainbookingsystem.entity.Passenger;

@Repository
public interface PassengerDao extends CrudRepository<Passenger, Integer> {

	@Query(value = "DELETE FROM PASSENGER P WHERE P.booking_passengers_pnrNo=?1", nativeQuery = true)
	void deleteAllByBookingPassengersPnrNo(long pnrNo);

}
