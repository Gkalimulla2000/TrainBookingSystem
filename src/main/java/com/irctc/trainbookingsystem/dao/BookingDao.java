package com.irctc.trainbookingsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainbookingsystem.entity.Booking;



@Repository
public interface BookingDao extends CrudRepository<Booking, Integer>{

}
