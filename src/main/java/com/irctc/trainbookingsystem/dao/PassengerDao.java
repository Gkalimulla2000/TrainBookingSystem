package com.irctc.trainbookingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainbookingsystem.entity.Passenger;

@Repository
public interface PassengerDao extends CrudRepository<Passenger, Integer> {

	@Query(value = "DELETE FROM PASSENGER P WHERE P.Pnr_No=?1", nativeQuery = true)
	void deleteAllByPnrNo(long pnrNo);

	@Query(value = "SELECT * FROM PASSENGER P WHERE P.Pnr_No=?1", nativeQuery = true)
	public List<Passenger> findAllByPnrNo(long pnrNo);

}
