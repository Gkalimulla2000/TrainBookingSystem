package com.irctc.trainbookingsystem.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainbookingsystem.entity.Booking;



@Repository
public interface BookingDao extends CrudRepository<Booking, Integer>{

	Optional<Booking> findByPnrNo(Long pnrNo);

public void deleteByPnrNo(long pnrNo);

}
