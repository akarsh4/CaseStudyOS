package com.sonata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sonata.controller.ProductController;
import com.sonata.model.products;
import com.sonata.repository.ProductRepository;

@SpringBootTest
class ProductProjectApplicationTests {

	@Autowired
	ProductController pcon;
	
	@MockBean
	ProductRepository prepo;
	 
    @Test
	public void getCat() {
		when(prepo.findAll()).thenReturn((List<products>) Stream.of(new products(1L,"samsung","Mobile",50000.0,"blue","white","f"),new products(2,"Apple","Mobile",50000.0,"blue","white","f")).collect(Collectors.toList()));
		assertEquals(2,pcon.getAllProducts().size());
	}
    @Test
    public void saveProducts() {
    	products prod = new products(1L,"samsung","Mobile",50000.0,"blue","white","f");
    	when(prepo.save(prod)).thenReturn(prod);
    	assertEquals(prod, pcon.saveProducts(prod));
    }
    @Test
    public void deleteProducts() {
    	products prod = new products(1L,"samsung","Mobile",50000.0,"blue","white","f");
    	pcon.deleteProducts(prod);
    	verify(prepo, times(1)).delete(prod);
    	
    }
    @Test
	  public void testUpdate() {
	  
	  products p=prepo.findById(1L).get();
	  p.setProd_price(5000);;
	  prepo.save(p);
	  assertNotEquals(100.00,prepo.findById(1L).get().getProd_price());
	  
		  
	  }

@Test
public void testDelete() {
	  prepo.deleteById(1L);
	  assertThat(prepo.existsById(1L)).isFalse();
	  
}
    
}