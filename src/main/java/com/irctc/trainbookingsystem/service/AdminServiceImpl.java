package com.irctc.trainbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.trainbookingsystem.dao.TrainDao;
import com.irctc.trainbookingsystem.dto.TrainDto;
import com.irctc.trainbookingsystem.entity.Train;
import com.irctc.trainbookingsystem.exception.DataAlreadyExistsException;
import com.irctc.trainbookingsystem.exception.MinimunDataRequiredException;
import com.irctc.trainbookingsystem.exception.NoDataPresentException;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private TrainDao trainDao;

	@Override
	public TrainDto addTrain(TrainDto trainDto) {
		
		
		Train train=new Train();
		BeanUtils.copyProperties(trainDto, train);
		Optional<Train> checkTrain = trainDao.findById(train.getTrainNo());
		String trainName = train.getTrainName();
		if (!checkTrain.isPresent() && !checkTrain.get().getTrainName().equalsIgnoreCase(trainName)) {
			if(
					checkTrain.get().getFirstACSeats()>10 &&
					checkTrain.get().getSecondACSeats()>10 &&
					checkTrain.get().getThirdACSeats()>10 &&
					checkTrain.get().getSleeperClassSeats()>=10 &&
					checkTrain.get().getSecondarySittingSeats()>10 &&
					
					checkTrain.get().getFarelist().getFirstAcFare()>=500 &&
					checkTrain.get().getFarelist().getSecondAcFare()>=400 &&
					checkTrain.get().getFarelist().getThirdAcFare()>=300 &&
					checkTrain.get().getFarelist().getSleeperClassFare()>=200 &&
					checkTrain.get().getFarelist().getSecondarySittingFare()>=100
					
					) {
				
				
			trainDao.save(train);
			return trainDto;
			}else
			{
				throw new MinimunDataRequiredException("All seats Should be greater than 10 \n "
						+ "All Fares should be greater than below:\n "
						+ "FirstAc 500 \n SecondAc 400 \n ThirdAc 300 \n SleeperClass 200 \n SecondarySitting 100");
			}
		} else {
			throw new DataAlreadyExistsException("The Train already Exists with same Number or Name");
		}

	}

	@Override
	public TrainDto getTrainByNumber(Long trainNumber) {
		Optional<Train> train = trainDao.findById(trainNumber);
		TrainDto trainDto=new TrainDto();
		BeanUtils.copyProperties(train, trainDto);
		if (train.isPresent()) {
			return trainDto;
		} else {
			throw new NoDataPresentException("Train Not Found with Number" + trainNumber);
		}

	}

	

	public boolean deleteTrain(Long trainNumber) {
		Optional<Train> train = trainDao.findById(trainNumber);
		if (train.isPresent()) {
			trainDao.deleteById(trainNumber);
			return true;
		} else
			throw new NoDataPresentException("Train Not Found with Number" + trainNumber);

	}

	@Override
	public TrainDto modifyTrain(Long trainNumber, TrainDto trainDto) {
		Optional<Train> checkTrain = trainDao.findById(trainNumber);
		
		Train newtrain=new Train();
		BeanUtils.copyProperties(trainDto,newtrain);
		if (checkTrain.isPresent()) {
			trainDao.save(newtrain);
			return trainDto;
		} else

			throw new NoDataPresentException("Train Not Found with Number" + trainNumber);
	}

	@Override
	public List<Train> getAllTrains() {
		// TODO Auto-generated method stub
		
		return (List<Train>) trainDao.findAll();
	}

}
