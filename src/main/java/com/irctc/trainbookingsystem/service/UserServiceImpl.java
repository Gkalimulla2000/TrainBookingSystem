package com.irctc.trainbookingsystem.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.trainbookingsystem.dao.UserDao;
import com.irctc.trainbookingsystem.dto.UserDto;
import com.irctc.trainbookingsystem.entity.User;
import com.irctc.trainbookingsystem.exception.DataAlreadyExistsException;
import com.irctc.trainbookingsystem.exception.MinimunDataRequiredException;
import com.irctc.trainbookingsystem.exception.NoDataPresentException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		Optional<User> userCheck = userDao.findById(user.getUserId());
		if (!userCheck.isPresent()) {
			User userSaved = userDao.save(user);
			BeanUtils.copyProperties(userSaved, userDto);
		
			return userDto;
		} else {

			throw new DataAlreadyExistsException("User already exists");
		}
	}

	@Override
	public UserDto getUserById(int userId) {

		Optional<User> userCheck=userDao.findById(userId);
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userCheck.get(), userDto);
		if(userCheck.isPresent()) {
			return userDto;
		}else {
			throw new NoDataPresentException("There is No user with ID " + userDto.getUserId());
		}
		
	}

	@Override
	public boolean deleteUserById(int userId) {
		Optional<User> userCheck=userDao.findById(userId);
		if(userCheck.isPresent()) {
			userDao.deleteById(userId);
			return true;
		}
		throw new NoDataPresentException("There is No user with ID " + userId);
	}

	@Override
	public UserDto UpdateUser(UserDto userDto) {
		
		Optional<User> userCheck = userDao.findById(userDto.getUserId());
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		if (userCheck.isPresent()) {
			userDao.save(user);
			return userDto;
		} else {

			throw new NoDataPresentException("There is No user with ID " + userDto.getUserId());
		}
	
	}

	@Override
	public String updatePassword(String userName, String oldPassword, String newPassword) {
		Optional<User> userCheck=userDao.findByUserName(userName);
		User user=userCheck.get();
		if(userCheck.isPresent()) {
			if(user.getPassword().equals(oldPassword)) {
				user.setPassword(newPassword);
				userDao.save(user);
				return "Password saved";
			}
		}
		throw new MinimunDataRequiredException("Please Enter correct UserName or oldPassword");
	}
}
