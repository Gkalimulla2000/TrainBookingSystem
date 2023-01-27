package com.irctc.trainbookingsystem.service;

import com.irctc.trainbookingsystem.dto.BookingDto;
import com.irctc.trainbookingsystem.entity.Booking;

public interface BookingService {

	public long bookTicket(BookingDto booking);
	public String cancelTicket(Long pnrNo);
	public Booking BookingInformation(Long pnrNo);

}
