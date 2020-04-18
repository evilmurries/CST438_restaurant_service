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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController
{
   @Autowired
   RestaurantService restaurantService;
   
   
   @RequestMapping("/restaurant/name/{name}")
   public ResponseEntity<Restaurant> findRestaurantByName(@PathVariable("name") String name) {
      Restaurant restaurant = restaurantService.getRestaurantName(name);
      if (restaurant == null) {
         return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
      }
      System.out.println(restaurant);
      return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
   }
   
   @GetMapping("/restaurant/id/{id}")
   public ResponseEntity<Restaurant> findRestaurantById(@PathVariable("id") int id) {
      Restaurant restaurant = restaurantService.getRestaurant(id);
      if (restaurant == null) {
         return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
      }
      System.out.println(restaurant);
      return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
   }
   
   @GetMapping("/restaurant")
   public ResponseEntity<Restaurant> findARestaurant() {
      Restaurant restaurant = restaurantService.getARestaurant();
      if (restaurant == null) {
         return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
      }
      System.out.println(restaurant);
      return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
   }
   
   @GetMapping("/restaurants")
   public ResponseEntity<List<Restaurant>> findRestaurants() {
      List<Restaurant> restaurant = restaurantService.getRestaurants();
      if (restaurant == null) {
         return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
      }
      System.out.println(restaurant);
      return new ResponseEntity<List<Restaurant>>(restaurant, HttpStatus.OK);
   }
   
}
