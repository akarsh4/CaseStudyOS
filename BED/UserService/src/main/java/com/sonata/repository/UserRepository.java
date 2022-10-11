package com.sonata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.model.user;



public interface UserRepository extends JpaRepository<user, Long> {

	 }


