package com.example.demo;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Restaurant;
import com.example.demo.RestaurantRepository;
import com.example.demo.RestaurantService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RestaurantServiceTest
{
   @Autowired
   private RestaurantService restaurantService;
   
   @MockBean
   private RestaurantRepository testRepository;
   
   @BeforeEach
   public void setupEach(){
      MockitoAnnotations.initMocks(this);
      restaurantService = new RestaurantService(testRepository);  
   }
   
   

   @Test
   public void testRestaurantFound() throws Exception {
      Restaurant testRestaurant = new Restaurant((long)1, "Giovannis", "italian", "$$$");
      given(testRepository.findByRestaurantName("testRestaurant")).willReturn(testRestaurant);
      given(restaurantService.getRestaurantName("Giovannis")).willReturn(new Restaurant((long)1, "Giovannis", "italian", "$$$"));
      Restaurant actual = restaurantService.getRestaurantName("testRestaurant");
      
      // Assertions
      assertThat( actual.getRestaurantName()).isEqualTo("Giovannis");
      assertThat( actual.getId()).isEqualTo((long)1);
      assertThat( actual.getCuisine()).isEqualTo("italian");
      assertThat( actual.getPrice()).isEqualTo("$$$");
   }
   
   @Test
   public void testRestaurantNotFound() throws Exception {
      Restaurant testRestaurant = new Restaurant((long)1, "giovannis", "italian", "$$$");
      given(testRepository.findByRestaurantName("testRestaurant")).willReturn(testRestaurant);
      given(restaurantService.getRestaurantName("Giovannis")).willReturn(new Restaurant((long)1, "giovannis", "italian", "$$$"));
      Restaurant actual = restaurantService.getRestaurantName("testRestaurant");
      
      // Assertions
      assertThat( actual.getRestaurantName()).isEqualTo("Giovannis");
      assertThat( actual.getId()).isEqualTo((long)1);
      assertThat( actual.getCuisine()).isEqualTo("italian");
      assertThat( actual.getPrice()).isEqualTo("$$$");
   }
   
   @Test
   public void testRestaurantId() throws Exception {
      Restaurant testRestaurant = new Restaurant((long)1, "Giovannis", "italian", "$$$");
      given(testRepository.findByRestaurantName("testRestaurant")).willReturn(testRestaurant);
      given(restaurantService.getRestaurant((long)1)).willReturn(new Restaurant((long)1, "Giovannis", "italian", "$$$"));
      Restaurant actual = restaurantService.getRestaurant((long)1);
      
      // Assertions
      assertThat( actual.getRestaurantName()).isEqualTo("Giovannis");
      assertThat( actual.getId()).isEqualTo((long)1);
      assertThat( actual.getCuisine()).isEqualTo("italian");
      assertThat( actual.getPrice()).isEqualTo("$$$");
   }
   
   @Test
   public void testRestaurantIdBad() throws Exception {
      Restaurant testRestaurant = new Restaurant((long)1, "Giovannis", "italian", "$$$");
      given(testRepository.findByRestaurantName("testRestaurant")).willReturn(testRestaurant);
      given(restaurantService.getRestaurant((long)1)).willReturn(new Restaurant((long)2, "Giovannis", "italian", "$$$"));
      Restaurant actual = restaurantService.getRestaurant((long)1);
      
      // Assertions
      assertThat( actual.getRestaurantName()).isEqualTo("Giovannis");
      assertThat( actual.getId()).isEqualTo((long)1);
      assertThat( actual.getCuisine()).isEqualTo("italian");
      assertThat( actual.getPrice()).isEqualTo("$$$");
   }
   
   
   @Test
   public void testGetRestaurants() throws Exception {
      Restaurant testRestaurant1 = new Restaurant((long)1, "giovannis", "italian", "$$$");
      Restaurant testRestaurant2 = new Restaurant((long)1, "giovannis", "italian", "$$$");
      List<Restaurant> testList = new ArrayList<Restaurant>();
      testList.add(testRestaurant1);
      testList.add(testRestaurant2);
      given(restaurantService.getRestaurants()).willReturn(new ArrayList<Restaurant>() {/**
          * 
          */
         private static final long serialVersionUID = 1L;

      {add(testRestaurant1); add(testRestaurant2); }});
      List<Restaurant> actual = restaurantService.getRestaurants();
      
      assertThat (actual.equals(testList));
   }
}
