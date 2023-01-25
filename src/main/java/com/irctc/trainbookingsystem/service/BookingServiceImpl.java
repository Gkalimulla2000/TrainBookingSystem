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

	@Override
	public long bookTicket(BookingDto bookingDto) {

		List<Passenger> passengers = bookingDto.getPassengers();

		Booking booking = new Booking();

		Optional<Booking> bookingCheck = bookingDao.findByPnrNo(booking.getPnrNo());
		BeanUtils.copyProperties(bookingDto, booking);
		if (!bookingCheck.isPresent()
				&& updateSeats(booking.getTrainNo(), booking.getClassType(), passengers.size(), booking.getPnrNo())
				&& updateBalance(booking.getUserId(), bookingCheck.get().getTotalFare())) {

			Booking book = bookingDao.save(booking);
			for (Passenger passenger : passengers) {
				passengerDao.save(passenger);

			}
			return book.getPnrNo();
		}
		throw new DataAlreadyExistsException(
				"Booking has Already Done or User Not Found or User Wallet Balance is low");
	}

	public boolean updateSeats(Long trainNo, String classType, int requiredSeats, long pnrNo) {
		Optional<Train> train = trainDao.findById(trainNo);
		Booking forFare = bookingDao.findByPnrNo(pnrNo).get();
		if (train.isPresent()) {
			if (classType.equalsIgnoreCase("FirstAc") && train.get().getFirstACSeats() >= requiredSeats) {
				int totalseats = train.get().getFirstACSeats() - requiredSeats;
				train.get().setFirstACSeats(totalseats);
				forFare.setTotalFare(train.get().getFarelist().getFirstAcFare() * requiredSeats);

			} else if (classType.equalsIgnoreCase("SecondAc") && train.get().getSecondACSeats() >= requiredSeats) {
				train.get().setSecondACSeats(train.get().getSecondACSeats() - requiredSeats);
				forFare.setTotalFare(train.get().getFarelist().getSecondAcFare() * requiredSeats);

			} else if (classType.equalsIgnoreCase("ThirdAc") && train.get().getThirdACSeats() >= requiredSeats) {
				train.get().setThirdACSeats(train.get().getThirdACSeats() - requiredSeats);
				forFare.setTotalFare(train.get().getFarelist().getThirdAcFare() * requiredSeats);

			} else if (classType.equalsIgnoreCase("SleeperClass")
					&& train.get().getSleeperClassSeats() >= requiredSeats) {
				train.get().setSleeperClassSeats(train.get().getSleeperClassSeats() - requiredSeats);
				forFare.setTotalFare(train.get().getFarelist().getSleeperClassFare() * requiredSeats);

			} else if (classType.equalsIgnoreCase("SecondarySitting")
					&& train.get().getSecondarySittingSeats() >= requiredSeats) {
				train.get().setSecondarySittingSeats(train.get().getSecondarySittingSeats() - requiredSeats);
				forFare.setTotalFare(train.get().getFarelist().getSecondarySittingFare() * requiredSeats);

			} else {
				throw new MinimunDataRequiredException("Please Enter correct ClassType ");
			}
			trainDao.save(train.get());
			return true;
		}

		return false;

	}

	public boolean updateBalance(int userId, long totalFare) {
		Optional<User> userCheck = userDao.findById(userId);
		if (userCheck.isPresent() && userCheck.get().getWalletBalance() >= totalFare) {
			userCheck.get().setWalletBalance(userCheck.get().getWalletBalance() - totalFare);
			return true;
		} else {
			return false;
		}

	}

	public String cancelTicket(long pnrNo) {
		Optional<Booking> booking = bookingDao.findByPnrNo(pnrNo);
		Train train = trainDao.findById(pnrNo).get();
		User user = userDao.findByUserId(booking.get().getUserId());

		if (booking.isPresent()) {
			if (booking.get().getClassType().equalsIgnoreCase("FirstAC")) {
				train.setFirstACSeats(train.getFirstACSeats() + booking.get().getPassengers().size());
			}
			if (booking.get().getClassType().equalsIgnoreCase("SecondAc")) {
				train.setSecondACSeats(train.getSecondACSeats() + booking.get().getPassengers().size());
			}

			if (booking.get().getClassType().equalsIgnoreCase("ThirdAc")) {
				train.setThirdACSeats(train.getThirdACSeats() + booking.get().getPassengers().size());
			}

			if (booking.get().getClassType().equalsIgnoreCase("SleeperClass")) {
				train.setSleeperClassSeats(train.getSleeperClassSeats() + booking.get().getPassengers().size());
			}

			if (booking.get().getClassType().equalsIgnoreCase("SecondarySitting")) {
				train.setSecondarySittingSeats(train.getSecondarySittingSeats() + booking.get().getPassengers().size());
			}

			user.setWalletBalance(booking.get().getTotalFare());
			bookingDao.deleteByPnrNo(pnrNo);
			passengerDao.deleteAllByBookingPassengersPnrNo(pnrNo);
			return "Ticket Cancelled ";
		}

		return "Something went Wrong! No Booking Found";

	}

	@Override
	public BookingDto BookingInformation(long pnrNo) {
		Optional<Booking> booking = bookingDao.findByPnrNo(pnrNo);

		return null;
	}

}
