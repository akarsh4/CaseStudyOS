package com.sonata.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sonata.model.orders;
import com.sonata.repository.OrderRepository;


@CrossOrigin(origins="http//localhost:4200")
@RestController

public class OrderController {
	Optional<orders> o1;
	
	@Autowired
	private OrderRepository prepository;
	
	@GetMapping("/order")
	public List<orders> getAllOrder(){
		return prepository.findAll();
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity getOrderById(@PathVariable(value = "id") long order_id) {
		o1 = prepository.findById((long) order_id);
		return ResponseEntity.ok().body(o1);
	}
	
	@PostMapping(value = "/order")
	public orders saveOrder(@RequestBody orders ord) {
		return prepository.save(ord);
	}
	
    @PutMapping(value="/order/{id}")
    public ResponseEntity updateOrder (@PathVariable(value="id") Long order_id,
    @Valid @RequestBody orders odata){
        o1 = prepository.findById(order_id);
        orders o2 = o1.get();
        o2.setOrder_id(odata.getOrder_id());
        o2.setProd_id(odata.getProd_id());
        o2.setOrder_status(odata.getOrder_status());
        o2.setPayment(odata.getPayment());
      
        orders updateOrder = prepository.save(o2);
        return ResponseEntity.ok(updateOrder);
    } 
	
    
    @DeleteMapping(value="/order/{id}")
    public ResponseEntity deleteOrders(@PathVariable(value="id")Long order_id) {
    	prepository.deleteById(order_id);
    	return ResponseEntity.noContent().build();
    }
	
}