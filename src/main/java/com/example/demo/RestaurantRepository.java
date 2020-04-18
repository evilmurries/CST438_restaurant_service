package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

   Restaurant findById(long id);
   
   Restaurant findByRestaurantName(String restaurantName);
   
   @Query(value="select * from restaurant limit 1", nativeQuery=true)
   public Restaurant findARestaurant();

   @Query(value="select * from restaurant order by id desc", nativeQuery=true)
   public List<Restaurant> findAllRestaurants();
   
}
