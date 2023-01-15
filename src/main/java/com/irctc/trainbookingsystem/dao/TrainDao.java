package com.irctc.trainbookingsystem.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irctc.trainbookingsystem.entity.Train;
@Repository
public interface TrainDao extends CrudRepository<Train, Long> {

	Optional<Train> findBytrainName(@Param("name")  String trainName);

	

}
