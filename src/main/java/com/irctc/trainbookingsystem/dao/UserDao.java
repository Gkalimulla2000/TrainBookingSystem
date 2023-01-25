package com.irctc.trainbookingsystem.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainbookingsystem.entity.User;
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	Optional<User> findByUserName(String userName);

	User findByUserId(int userId);

}
