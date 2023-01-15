package com.irctc.trainbookingsystem.service;

import java.util.List;

import com.irctc.trainbookingsystem.dto.TrainDto;
import com.irctc.trainbookingsystem.entity.Train;

public interface AdminService {

	public Train addTrain(TrainDto trainDto);
	public TrainDto getTrainByNumber(Long trainNumber);
	public boolean deleteTrain(Long trainNumber);
	public TrainDto modifyTrain(Long trainNumber,TrainDto trainDto);
	public List<Train> getAllTrains();
}
