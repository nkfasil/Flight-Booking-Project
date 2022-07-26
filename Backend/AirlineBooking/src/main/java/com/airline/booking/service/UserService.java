package com.airline.booking.service;


import org.springframework.stereotype.Service;

import com.airline.booking.entity.User;

@Service
public interface UserService {

	public User findUser(Integer id);
	
	public User saveUser(User user);
	
	public User findByEmailId(String emailId);
}
