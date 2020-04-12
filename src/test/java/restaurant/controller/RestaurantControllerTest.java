package restaurant.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Restaurant;
import com.example.demo.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestaurantControllerTest
{
   @MockBean
   private RestaurantService restaurantService;
   
   @Autowired
   private MockMvc mvc;
   
   private JacksonTester<Restaurant> json;
   

   @BeforeAll
   public void setup() {
      JacksonTester.initFields(this, new ObjectMapper());
   }
   
   @Test
   public void contextLoads() {
   }

   @Test
   public void testGetRestaurantByName() throws Exception {
      
      Restaurant attempt = new Restaurant(1, "Giovannis", "Italian", "$$$");
      Restaurant expected = new Restaurant(1, "Giovannis", "Italian", "$$$");
      Restaurant expected2 = new Restaurant(1, "giovannis", "Italian", "$$$");
      
      given(restaurantService.getRestaurantName(attempt.getRestaurantName())).willReturn(expected);
      
      // when
      MockHttpServletResponse response = mvc.perform(
            get("api/restaurant/name/{name}").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(
            json.write(expected).getJson());
      
      // When name is bad
      MockHttpServletResponse response2 = mvc.perform(
            get("api/restaurant/name/{name}").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response2.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response2.getContentAsString()).isEqualTo(
            json.write(expected2).getJson());
   }
   
   @Test
   public void testGetRestaurantById() throws Exception {
      
      Restaurant attempt = new Restaurant(1, "Giovannis", "Italian", "$$$");
      Restaurant expected = new Restaurant(1, "Giovannis", "Italian", "$$$");
      Restaurant expected2 = new Restaurant(2, "Giovannis", "Italian", "$$$");
      
      given(restaurantService.getRestaurant(attempt.getId())).willReturn(expected);
      
      // when
      MockHttpServletResponse response = mvc.perform(
            get("api/restaurant/id/{id}").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(
            json.write(expected).getJson());
      
      // When id is bad
      MockHttpServletResponse response2 = mvc.perform(
            get("api/restaurant/id/{id}").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response2.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response2.getContentAsString()).isEqualTo(
            json.write(expected2).getJson());
   }
   
   @Test
   public void testGetRestaurant() throws Exception {
      
      Restaurant attempt = new Restaurant(1, "Giovannis", "Italian", "$$$");
      Restaurant expected = new Restaurant(1, "Giovannis", "Italian", "$$$");
      
      given(restaurantService.getARestaurant()).willReturn(expected);
      
      // when
      MockHttpServletResponse response = mvc.perform(
            get("api/restaurant").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(
            json.write(expected).getJson());
   }
   
   @Test
   public void testGetRestaurants() throws Exception {
      Restaurant testRestaurant1 = new Restaurant((long)1, "giovannis", "italian", "$$$");
      Restaurant testRestaurant2 = new Restaurant((long)1, "giovannis", "italian", "$$$");
      List<Restaurant> expected = new ArrayList<Restaurant>();
      expected.add(testRestaurant1);
      expected.add(testRestaurant2);
      
      List<Restaurant> attempt = new ArrayList<Restaurant>(); 

      
      given(restaurantService.getRestaurants()).willReturn(expected);
      
      // when
      MockHttpServletResponse response1 = mvc.perform(
            get("api/restaurant").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt.get(0)).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response1.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response1.getContentAsString()).isEqualTo(
            json.write(expected.get(0)).getJson());
      
      MockHttpServletResponse response2 = mvc.perform(
            get("api/restaurant").contentType(MediaType.APPLICATION_JSON)
               .content(json.write(attempt.get(1)).getJson()))
            .andReturn().getResponse();
      
      // then
      assertThat(response2.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response2.getContentAsString()).isEqualTo(
            json.write(expected.get(1)).getJson());
   }
}
