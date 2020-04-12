package restaurant.controller;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.RestaurantService;

@SpringBootTest
public class RestaurantControllerTest
{
   @Mock
   private RestaurantService restaurantService;
}
