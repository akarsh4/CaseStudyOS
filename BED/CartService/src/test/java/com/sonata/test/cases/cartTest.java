package com.sonata.test.cases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sonata.model.cart;
import com.sonata.repository.CartRepository;


	@DataJpaTest
	@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
	class cartTest{
		    @Autowired
		    public CartRepository prepository;
		    Optional<cart> p1;
		    
		      @Test
		      public void getAllCartDataTest(){
		  List<cart> products = prepository.findAll();
		            Assertions.assertThat(products.size()).isEqualTo(2);
		            
		            System.out.println(products);
		        }
		      
		      @Test 
		      public void testCreate() {
		    	  cart p=new cart();
		    	  p.setCart_id(101L);
		    	  p.setProd_quantity(2);
		    	  p.setPayment_mode("cash");
		    	  
		    	  prepository.save(p);
		    	  assertNotNull(prepository.findById(101L).get());
		      }
		      
		      @Test
		      public void testReadALL() {
		    	  List <cart> list=prepository.findAll();
		    	  assertThat(list).size().isGreaterThan(0);
		      }
		      @Test
		      public void testDelete() {
		    	  prepository.deleteById(4L);
		    	  assertThat(prepository.existsById(4L)).isFalse();
		    	  
		      }


}
