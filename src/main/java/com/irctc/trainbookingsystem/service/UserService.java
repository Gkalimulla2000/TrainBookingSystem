package com.irctc.trainbookingsystem.service;

import com.irctc.trainbookingsystem.dto.UserDto;

public interface UserService {
 public UserDto addUser(UserDto userDto);

public UserDto getUserById(int userId);

public boolean deleteUserById(int userId);

public UserDto UpdateUser( UserDto userDto);

public String updatePassword(String userName, String oldPassword, String newPassword);

}
