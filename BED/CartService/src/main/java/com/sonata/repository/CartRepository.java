package com.sonata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.model.cart;


public interface CartRepository extends JpaRepository<cart,Long>{

}
