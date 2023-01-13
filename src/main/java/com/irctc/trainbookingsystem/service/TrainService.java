package com.irctc.trainbookingsystem.service;

import java.util.List;

import com.irctc.trainbookingsystem.dto.TrainDto;
import com.irctc.trainbookingsystem.entity.Train;

public interface TrainService {
	public List<Train> getAllTrainsFromSourceToDestination(String StartStation ,String DestinationStation);

	public int getTrainFaresByClassType(Long trainNumber, String classType);

	public TrainDto getTrainByName(String trainName);

}
