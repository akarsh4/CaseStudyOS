package com.sonata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sonata.controller.OrderController;
import com.sonata.model.orders;
import com.sonata.repository.OrderRepository;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	OrderController ocon;
	
	@MockBean
	OrderRepository orepo;
	
	 @Test
		public void getCat() {
			when(orepo.findAll()).thenReturn((List<orders>) Stream.of(new orders(1L,2L,"Phonepe","Proccessing"),new orders(1L,2L,"Phonepe","Proccessing")).collect(Collectors.toList()));
			assertEquals(2,ocon.getAllOrder().size());
		}
	    @Test
	    public void saveProducts() {
	    	orders  orderprod = new orders(1L,2L,"Phonepe","Proccessing");
	    	when(orepo.save(orderprod)).thenReturn(orderprod);
	    	assertEquals(orderprod, ocon.saveOrder(orderprod));
	    }

	      @Test
	      public void getAllCartDataTest(){
	  List<orders> products = orepo.findAll();
	            Assertions.assertThat(products.size()).isEqualTo(2);
	            
	            System.out.println(products);
	        }
	      
	      @Test 
	      public void testCreate() {
	    	  orders p=new orders();
	    	  p.setOrder_id(101L);
	    	
	    	  p.setPayment("Done");

	    	  
	    	  orepo.save(p);
	    	  assertNotNull(orepo.findById(101L).get());
	      }
	      
	      @Test
	      public void testReadALL() {
	    	  List <orders> list=orepo.findAll();
	    	  assertThat(list).size().isGreaterThan(0);
	      }
	      @Test
	      public void testSingleProduct() {
	    	 orders product=orepo.findById(1L).get();
	    	  assertEquals(101L,product.getOrder_id());
	      }
	    
	      @Test
	      public void testDelete() {
	    	  orepo.deleteById(1L);
	    	  assertThat(orepo.existsById(1L)).isFalse();
	    	  
	      }

}
