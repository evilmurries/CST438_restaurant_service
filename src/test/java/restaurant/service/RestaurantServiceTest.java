package restaurant.service;

import org.junit.*;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.RestaurantRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class RestaurantServiceTest
{
   @Mock
   private RestaurantRepository testRepository;

}
