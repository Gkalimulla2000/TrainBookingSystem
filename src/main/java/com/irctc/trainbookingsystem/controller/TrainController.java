package com.irctc.trainbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainbookingsystem.dto.TrainDto;
import com.irctc.trainbookingsystem.service.AdminService;
import com.irctc.trainbookingsystem.service.TrainService;

@RestController
@RequestMapping("/Train")
public class TrainController {
@Autowired
private TrainService trainService;
@Autowired
private AdminService adminService;

@GetMapping("/getTrainFares{trainNumber}&{classType}")
public ResponseEntity<?> getTrainFaresByClassType(@PathVariable Long trainNumber ,@PathVariable String classType){
	
	
	return new ResponseEntity<>(trainService.getTrainFaresByClassType(trainNumber,classType),HttpStatus.OK);
	
}

@GetMapping("/getAllTrainsFromSourceToDestination{startStation}&{destinationStation}")
public ResponseEntity<?> getAllTrainsFromSourceToDestination(@PathVariable String startStation ,@PathVariable String destinationStation){
	
	
	return new ResponseEntity<>(trainService.getAllTrainsFromSourceToDestination(startStation, destinationStation),HttpStatus.OK);
	
}
@GetMapping("/getTrainByName{trainName}")
public ResponseEntity<?> getTrainByName(@PathVariable String trainName){
	
	
	return new ResponseEntity<>(trainService.getTrainByName(trainName),HttpStatus.OK);
	
}
@GetMapping("/getTrainByID{trainNumber}")

public ResponseEntity<?> getTrainById(@PathVariable Long trainNumber){
	TrainDto train=adminService.getTrainByNumber(trainNumber); 
	return new ResponseEntity<>(train,HttpStatus.OK);
	
}
	
}
