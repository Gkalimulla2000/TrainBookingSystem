package com.irctc.trainbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainbookingsystem.dto.TrainDto;
import com.irctc.trainbookingsystem.entity.Train;
import com.irctc.trainbookingsystem.service.AdminService;

@RestController
@RequestMapping("/IRCTC")
public class AdminController {
@Autowired
private AdminService adminService;
	@PostMapping("/addTrain")
	public ResponseEntity<?> addTrain(@RequestBody TrainDto trainDto)
	{
		
		return new ResponseEntity<>(adminService.addTrain(trainDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getTrainByID{trainNumber}")
		
	public ResponseEntity<?> getTrainById(@PathVariable Long trainNumber){
		TrainDto train=adminService.getTrainByNumber(trainNumber); 
		return new ResponseEntity<>(train,HttpStatus.OK);
		
	}
	
	@PutMapping("/modifyTrain{trainNumber}")
	public  ResponseEntity<?> modifyTrain(@RequestBody TrainDto trainDto,@PathVariable Long trainNumber){
		return new ResponseEntity<>(adminService.modifyTrain(trainNumber, trainDto),HttpStatus.OK);
	}
	@DeleteMapping("/deleteTrain")
	public ResponseEntity<?> deleteTrainById(@PathVariable Long trainNumber){
		return new ResponseEntity<>(adminService.deleteTrain(trainNumber),HttpStatus.OK);
	}
	
	@GetMapping("/getAllTrains")
	public List<Train> getAllTrains(){
		return adminService.getAllTrains();
	}
}
