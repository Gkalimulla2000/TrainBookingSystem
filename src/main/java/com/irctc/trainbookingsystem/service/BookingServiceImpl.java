package com.irctc.trainbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.trainbookingsystem.dao.BookingDao;
import com.irctc.trainbookingsystem.dao.PassengerDao;
import com.irctc.trainbookingsystem.dao.TrainDao;
import com.irctc.trainbookingsystem.dao.UserDao;
import com.irctc.trainbookingsystem.dto.BookingDto;
import com.irctc.trainbookingsystem.entity.Booking;
import com.irctc.trainbookingsystem.entity.Passenger;
import com.irctc.trainbookingsystem.entity.Train;
import com.irctc.trainbookingsystem.entity.User;
import com.irctc.trainbookingsystem.exception.DataAlreadyExistsException;
import com.irctc.trainbookingsystem.exception.MinimunDataRequiredException;
import com.irctc.trainbookingsystem.exception.NoDataPresentException;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private PassengerDao passengerDao;
	@Autowired
	private TrainDao trainDao;
	@Autowired
	private UserDao userDao;

	int totalfare = 0;

	@Override
	public long bookTicket(BookingDto bookingDto) {

		List<Passenger> passengers = bookingDto.getPassengers();

		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingDto, booking);
		Optional<Booking> bookingCheck = bookingDao.findByPnrNo(booking.getPnrNo());

		
		
		if (!bookingCheck.isPresent()
				&& updateSeats(booking.getTrainNo(), booking.getClassType(), passengers.size(), booking.getPnrNo())
				&& updateBalance(booking.getUserId(), totalfare)) {

			Booking book = bookingDao.save(booking);
			book.setTotalFare(totalfare);
			
			return book.getPnrNo();
		}
		throw new DataAlreadyExistsException(
				"Booking has Already Done or User Not Found or User Wallet Balance is low");
	}

	public boolean updateSeats(Long trainNo, String classType, int requiredSeats, long pnrNo) {
		Optional<Train> train = trainDao.findById(trainNo);
		// Booking forFare = bookingDao.findByPnrNo(pnrNo).orElse(null);
		if (train.isPresent()) {
			if (classType.equalsIgnoreCase("FirstAc") && train.get().getFirstACSeats() >= requiredSeats) {
				int totalseats = train.get().getFirstACSeats() - requiredSeats;
				train.get().setFirstACSeats(totalseats);
				// forFare.setTotalFare(train.get().getFarelist().getFirstAcFare() *
				// requiredSeats);
				totalfare = train.get().getFarelist().getFirstAcFare() * requiredSeats;

			} else if (classType.equalsIgnoreCase("SecondAc") && train.get().getSecondACSeats() >= requiredSeats) {
				train.get().setSecondACSeats(train.get().getSecondACSeats() - requiredSeats);
				// forFare.setTotalFare(train.get().getFarelist().getSecondAcFare() *
				// requiredSeats);
				totalfare = train.get().getFarelist().getSecondAcFare() * requiredSeats;

			} else if (classType.equalsIgnoreCase("ThirdAc") && train.get().getThirdACSeats() >= requiredSeats) {
				train.get().setThirdACSeats(train.get().getThirdACSeats() - requiredSeats);
				// forFare.setTotalFare(train.get().getFarelist().getThirdAcFare() *
				// requiredSeats);

			} else if (classType.equalsIgnoreCase("SleeperClass")
					&& train.get().getSleeperClassSeats() >= requiredSeats) {
				train.get().setSleeperClassSeats(train.get().getSleeperClassSeats() - requiredSeats);
				// forFare.setTotalFare(train.get().getFarelist().getSleeperClassFare() *
				// requiredSeats);
				totalfare = train.get().getFarelist().getSleeperClassFare() * requiredSeats;

			} else if (classType.equalsIgnoreCase("SecondarySitting")
					&& train.get().getSecondarySittingSeats() >= requiredSeats) {
				train.get().setSecondarySittingSeats(train.get().getSecondarySittingSeats() - requiredSeats);
				// forFare.setTotalFare(train.get().getFarelist().getSecondarySittingFare() *
				// requiredSeats);
				totalfare = train.get().getFarelist().getSecondarySittingFare() * requiredSeats;

			} else {
				throw new MinimunDataRequiredException("Please Enter correct ClassType ");
			}
			trainDao.save(train.get());
			return true;
		}
		// throw new NoDataPresentException("No train present");

		return false;

	}

	public boolean updateBalance(int userId, long totaluserFare) {
		Optional<User> userCheck = userDao.findById(userId);
		if (userCheck.isPresent() && userCheck.get().getWalletBalance() >= totaluserFare) {
			userCheck.get().setWalletBalance(userCheck.get().getWalletBalance() - totaluserFare);
			return true;
		} else {
			return false;
		}

	}

	public String cancelTicket(Long pnrNo) {
		Optional<Booking> booking = bookingDao.findById(pnrNo);
		
		if (booking.isPresent()) {
			Optional<Train> train = trainDao.findById(booking.get().getTrainNo());
			User user = userDao.findByUserId(booking.get().getUserId());

			if (booking.get().getClassType().equalsIgnoreCase("FirstAC")) {
				train.get().setFirstACSeats(train.get().getFirstACSeats() + booking.get().getPassengers().size());
			}
			if (booking.get().getClassType().equalsIgnoreCase("SecondAc")) {
				train.get().setSecondACSeats(train.get().getSecondACSeats() + booking.get().getPassengers().size());
			}

			if (booking.get().getClassType().equalsIgnoreCase("ThirdAc")) {
				train.get().setThirdACSeats(train.get().getThirdACSeats() + booking.get().getPassengers().size());
			}

			if (booking.get().getClassType().equalsIgnoreCase("SleeperClass")) {
				train.get().setSleeperClassSeats(train.get().getSleeperClassSeats() + booking.get().getPassengers().size());
			}

			if (booking.get().getClassType().equalsIgnoreCase("SecondarySitting")) {
				train.get().setSecondarySittingSeats(train.get().getSecondarySittingSeats() + booking.get().getPassengers().size());
			}

			user.setWalletBalance(user.getWalletBalance()+booking.get().getTotalFare());
			trainDao.save(train.get());
			bookingDao.deleteById(pnrNo);
			return "Ticket Cancelled ";
		}

		return "Something went Wrong! No Booking Found";

	}

	@Override
	public Booking BookingInformation(Long pnrNo) {
		Optional<Booking> booking = bookingDao.findById(pnrNo);
		//List<Passenger> passengers=passengerDao.findAllByPnrNo(pnrNo);
		if (booking.isPresent()) {
		//	booking.get().setPassengers(passengers);
			return booking.get();
		} else {
			throw new NoDataPresentException("No booking found");
		}

	}

	
}
