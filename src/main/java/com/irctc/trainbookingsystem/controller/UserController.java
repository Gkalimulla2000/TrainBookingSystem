package com.irctc.trainbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainbookingsystem.dto.UserDto;
import com.irctc.trainbookingsystem.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
	}

	@GetMapping("/getUser{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);

	}

	@DeleteMapping("/deleteUser{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable int userId) {
		return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
	}

	@PutMapping(path="/updateUser ")
	public ResponseEntity<?> UpdateUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.UpdateUser(userDto), HttpStatus.OK);
	}

	@GetMapping("/updatePassword{userName} & {oldPassword} & {NewPassword}")
	public ResponseEntity<?> updatePassword(@PathVariable String userName, @PathVariable String oldPassword,
			@PathVariable String NewPassword) {
		return new ResponseEntity<>(userService.updatePassword(userName, oldPassword, NewPassword),
				HttpStatus.ACCEPTED);

	}
}
