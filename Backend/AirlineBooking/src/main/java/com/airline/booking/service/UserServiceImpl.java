package com.airline.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.booking.entity.User;
import com.airline.booking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User findUser(Integer id) {
		Optional<User> userOp = userRepository.findById(id);
		if (userOp.isPresent())
			return userOp.get();
		else
			// throw exception
			return null;
	}

	@Override
	public User saveUser(User user) {
		Optional<User> userOp = userRepository.findByEmail(user.getEmail());
		if (!userOp.isPresent())
			return userRepository.save(user);
		else
			return userOp.get();
	}

	@Override
	public User findByEmailId(String emailId) {
		Optional<User> userOp = userRepository.findByEmail(emailId);
		if (!userOp.isPresent())
			return null;//throw exception
		else
			return userOp.get();
	}

}
