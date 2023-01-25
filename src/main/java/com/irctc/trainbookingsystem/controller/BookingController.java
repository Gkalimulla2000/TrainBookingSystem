package com.irctc.trainbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainbookingsystem.dto.BookingDto;
import com.irctc.trainbookingsystem.service.BookingService;

@RestController
public class BookingController {
@Autowired
private BookingService bookingService;

@PostMapping("/bookTicket")
public ResponseEntity<?> bookTicket(@RequestBody BookingDto bookingDto){
	return new ResponseEntity<>(bookingService.bookTicket(bookingDto),HttpStatus.ACCEPTED);
}

@GetMapping("/cancelTicket")
public ResponseEntity<?> cancelTicket(@RequestParam long pnrNo){
	return new ResponseEntity<>(bookingService.cancelTicket(pnrNo),HttpStatus.OK);
}

@GetMapping("/bookingInformation")
public ResponseEntity<?> bookingInfrmation(@RequestParam long pnrNo){
	return new ResponseEntity<>(bookingService.BookingInformation(pnrNo),HttpStatus.OK);
}

}
