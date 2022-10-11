package com.sonata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.model.products;



public interface ProductRepository extends JpaRepository<products, Long> {

	 }


