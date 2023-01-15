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
		
		try {
			
			Optional<Train> trainCheck = trainDao.findBytrainName(trainName);
					
			TrainDto trainDto=new TrainDto();
			BeanUtils.copyProperties(trainCheck.get(), trainDto);
		if (trainCheck.isPresent()) {
			return trainDto;
		} else {	
			throw new NullPointerException("Train Not Found with Name" + trainName);
		}
		}catch(Exception e) {
			throw new NullPointerException(e.getMessage());
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
	 Optional<Train> trainCheck=trainDao.findById(trainNumber);
	 Train train=trainCheck.get();
	 if(trainCheck.isPresent()) {
		 if( classType.equalsIgnoreCase("FirstAc")) {
			 return train.getFarelist().getFirstAcFare();
			 
		 }else if( classType.equalsIgnoreCase("SecondAc")) {
			 return train.getFarelist().getSecondAcFare();
			 
		 }else if( classType.equalsIgnoreCase("ThirdAc")) {
			 return train.getFarelist().getThirdAcFare();
			 
		 }else if( classType.equalsIgnoreCase("SleeperClass")) {
		 return train.getFarelist().getSleeperClassFare();
		
		 }else if( classType.equalsIgnoreCase("SecondarySitting")) {
		 return train.getFarelist().getSecondarySittingFare();
		 }else {
		throw new NoDataPresentException("Please Send the Correct ClassType");
		 }

}else {
	throw new NoDataPresentException("There is no Train with Number"+trainNumber);
}
	}
}
