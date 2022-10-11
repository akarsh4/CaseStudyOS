package com.sonata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.model.orders;



public interface OrderRepository extends JpaRepository<orders,Long>{

}
