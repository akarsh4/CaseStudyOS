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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.model.products;
import com.sonata.repository.ProductRepository;


 
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	Optional<products> p1;
	
	@Autowired
	private ProductRepository prepository;
	
	@GetMapping("getall")
	public List<products> getAllProducts(){
		return prepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity getProductsById(@PathVariable(value="id") Long prod_id) {
		p1 = prepository.findById(prod_id);
		return ResponseEntity.ok().body(p1);
	}
	
	@PostMapping("/products")
	public products saveProducts(@RequestBody products prod) {
		return prepository.save(prod);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity updateProducts (@PathVariable(value="id") Long prod_id,
	@Valid @RequestBody products pdata){
		p1 = prepository.findById(prod_id);
		products e2 = p1.get();
		e2.setProd_id(pdata.getProd_id());
		e2.setProd_name(pdata.getProd_name());
		e2.setProd_category(pdata.getProd_category());
		e2.setProd_price(pdata.getProd_price());
		e2.setProd_color(pdata.getProd_color());
		e2.setProd_description(pdata.getProd_description());
		e2.setProd_image(pdata.getProd_image());
		
		products updateProducts = prepository.save(e2);
		return ResponseEntity.ok(updateProducts);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity deleteProducts(@PathVariable(value="id")products prod) {
		prepository.delete(prod);
		return ResponseEntity.noContent().build();
	}
	
	
}

