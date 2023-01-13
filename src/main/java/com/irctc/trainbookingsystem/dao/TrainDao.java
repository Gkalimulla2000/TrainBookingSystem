package com.irctc.trainbookingsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.irctc.trainbookingsystem.entity.Train;

public interface TrainDao extends CrudRepository<Train, Long> {

	Train findBytrainName(@Param("name")  String trainName);

	

}
