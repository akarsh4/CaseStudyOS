package com.sonata.mvc.test;



import java.util.Optional;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import java.util.List;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sonata.model.user;
import com.sonata.repository.UserRepository;








@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTest {
    @Autowired
    public UserRepository prepository;
    Optional <user> p1;
    
      @Test
      public void getAllCartDataTest(){
  List<user> users = prepository.findAll();
            Assertions.assertThat(users.size()).isEqualTo(0);
            
            System.out.println(users);
        }
      
      @Test
      public void testCreate() {
          user p=new user();
          p.setUser_name("sid");
          p.setUser_address("bangalore");
          p.setUser_email("sid@gmail.com");
          p.setUser_phone(987654321L);
         
          prepository.save(p);
          assertNotNull(prepository.findById(987654321L).get());
      }
      
      @Test
      public void testReadALL() {
          List <user> list=prepository.findAll();
          assertThat(list).size().isGreaterThan(0);
      }
      @Test
      public void testSingleProduct() {
         user p=prepository.findById(987654321L).get();
          assertEquals("sid",p.getUser_name());
      }
      @Test
          public void testUpdate() {
          
        user p=prepository.findById(1L).get();
          p.setUser_name("sid123");
          prepository.save(p);
          assertNotEquals("sid123",prepository.findById(987654321L).get().getUser_name());
          
              
          }
      
      @Test
      public void testDelete() {
          prepository.deleteById(1L);
          assertThat(prepository.existsById(1L)).isFalse();
          
      }
}