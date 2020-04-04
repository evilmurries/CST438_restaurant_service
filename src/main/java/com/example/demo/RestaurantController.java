package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController
{
   @Autowired
   RestaurantService restaurantService;
   
   
   @GetMapping("/restaurant/{id}")
   public ResponseEntity<Restaurant> findRestaurantById(@PathVariable("id") int id) {
      Restaurant restaurant = restaurantService.getRestaurant(id);
      if (restaurant == null) {
         return new ResponseEntity<Restaurant>( HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
   }
   
   @GetMapping("/restaurant")
   public String test() {
      return "welcome";
   }
}
