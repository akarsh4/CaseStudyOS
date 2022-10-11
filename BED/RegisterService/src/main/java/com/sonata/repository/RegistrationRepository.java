package com.sonata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.model.user;

public interface RegistrationRepository extends JpaRepository<user,Long>{
	public user findByEmailId(String emailId);
	public user findByEmailIdAndPassword(String emailId,String password);
	
}
