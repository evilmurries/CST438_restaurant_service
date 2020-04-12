package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantService
{

   private static final Logger log = 
         LoggerFactory.getLogger(RestaurantService.class);
   
   @Autowired
   RestaurantRepository restaurantRepository;
   
   public RestaurantService(RestaurantRepository restaurantRepository) {
      this.restaurantRepository = restaurantRepository;
   }
   
   public Restaurant getRestaurant(int id) {
      Restaurant r = restaurantRepository.findById(id);
      if (r != null ) {
            log.info("Restaurant Found: " + r.toString());
           return r;
      } else {
         log.info("No Restaurant Found with that id");
         return null;
      }
   }
   
   public Restaurant getRestaurantName(String name) {
      Restaurant r = restaurantRepository.findByRestaurantName(name);
      if (r != null ) {
            log.info("Restaurant Found: " + r.toString());
           return r;
      } else {
         log.info("No Restaurant Found with that name");
         return null;
      }
   }
   
   public Restaurant getARestaurant() {
      Restaurant r = restaurantRepository.findARestaurant();
      if (r != null ) {
            log.info("Restaurant Found: " + r.toString());
           return r;
      } else {
         log.info("No Restaurant Found");
         return null;
      }
   }
   
   public List<Restaurant> getRestaurants() {
      List<Restaurant> r = restaurantRepository.findAllRestaurants();
      if (r != null ) {
            log.info("Restaurants Found");
           return r;
      } else {
         log.info("No Restaurants Found");
         return null;
      }
   }
}
