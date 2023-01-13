package com.irctc.trainbookingsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.trainbookingsystem.dao.TrainDao;
import com.irctc.trainbookingsystem.dto.TrainDto;
import com.irctc.trainbookingsystem.entity.Train;
import com.irctc.trainbookingsystem.exception.NoDataPresentException;

@Service
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainDao trainDao;
	
	@Override
	public TrainDto getTrainByName(String trainName) {
		Train train=trainDao.findBytrainName(trainName);
		Optional<Train> trainCheck = trainDao.findById(train.getTrainNo());
		TrainDto trainDto=new TrainDto();
		BeanUtils.copyProperties(train, trainDto);
		if (trainCheck.isPresent()) {
			return trainDto;
		} else {
			throw new NoDataPresentException("Train Not Found with Number" + trainName);
		}

	}
	
	public List<Train> getAllTrainsFromSourceToDestination(String StartStation, String DestinationStation) {

		List<Train> allTrains = (List<Train>) trainDao.findAll();
		List<Train> list = allTrains.stream()
				.filter(train -> train.getArrivalLocation().getStationName().equalsIgnoreCase(StartStation))
				.filter(train -> train.getDepartureLocation().getStationName().equalsIgnoreCase(DestinationStation))
				.collect(Collectors.toList());
		if (!list.isEmpty()) {
			return list;
		} else
			throw new NoDataPresentException("No Trains Found SourceStation To DestinationStation ");
		
	}

	@Override
	public int getTrainFaresByClassType(Long trainNumber, String classType) {
	 Optional<Train> train=trainDao.findById(trainNumber);
	 if(train.isPresent()) {
		 if( classType.equalsIgnoreCase("FirstAc")) {
			 return train.get().getFarelist().getFirstAcFare();
			 
		 }else if( classType.equalsIgnoreCase("SecondAc")) {
			 return train.get().getFarelist().getSecondAcFare();
			 
		 }else if( classType.equalsIgnoreCase("ThirdAc")) {
			 return train.get().getFarelist().getThirdAcFare();
			 
		 }else if( classType.equalsIgnoreCase("SleeperClass")) {
		 return train.get().getFarelist().getSleeperClassFare();
		
		 }else if( classType.equalsIgnoreCase("SecondarySitting")) {
		 return train.get().getFarelist().getSecondarySittingFare();
		 }else {
		throw new NoDataPresentException("Please Send the Correct ClassType");
		 }

}else {
	throw new NoDataPresentException("There is no Train with Number"+trainNumber);
}
	}
}
