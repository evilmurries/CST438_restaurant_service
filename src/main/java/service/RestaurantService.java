package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Restaurant;
import domain.RestaurantRepository;


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
         log.info("No restaurant found with that id");
         return null;
      }
   }
   
}
