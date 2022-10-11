package com.sonata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonata.model.user;
import com.sonata.repository.RegistrationRepository;


@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
public user saveUser(user user) {
	return repo.save(user);
}
public user fetchUserByEmailId(String email) {
	return repo.findByEmailId(email);
}

public user fetchUserByEmailIdAndPassword(String email, String password) {
	return repo.findByEmailIdAndPassword(email, password);
}
}
