package com.example.SwiggyCustomer.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.SwiggyCustomer.model.APPRECIATION;
import com.example.SwiggyCustomer.model.Item;
import com.example.SwiggyCustomer.model.ORDERSTATUS;
import com.example.SwiggyCustomer.model.Order;
import com.example.SwiggyCustomer.model.OrderTracking;
import com.example.SwiggyCustomer.model.Restaurant;


@RestController
@RequestMapping(value="/swiggyCustomer")
public class SwiggyCutomerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path="/getAllRestaurants")
    public List<Restaurant> getAllRestaurants(){
		
		ResponseEntity<List<Restaurant>> response = restTemplate.exchange(
				  "http://localhost:8989/swiggy/getAllRestaurants",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Restaurant>>(){});
		List<Restaurant> restaurants = response.getBody();
				
		return restaurants;
		
	}
	
	@GetMapping(path="/getRestaurantItems/{id}")
    public List<Item> getRestaurantItems(@PathVariable long id) {
		
		final String uri = "http://localhost:8989/swiggy/getRestaurantItems/{id}";
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		ResponseEntity<List<Item>> response = restTemplate.exchange(
				  uri,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Item>>(){},params);
		
		List<Item> items = response.getBody();
		
		return items;
    }	
	
	@GetMapping(path="/cancelOrder/{id}")
    public String getCustomerOrderCancelled(@PathVariable long id) {
		
		final String uri = "http://localhost:8989/swiggy/cancelOrder/{id}";
		
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		restTemplate.put(uri, Order.class, params);
	    
	    return "Order Canceled";
    }
	
	@GetMapping(path="/getOrder/{id}")
    public String getCustomerOrder(@PathVariable long id) {
		
		final String uri = "http://localhost:8989/swiggy/getOrder/{id}";
		
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		Order order = restTemplate.getForObject(uri, Order.class, params);
	    
	    return order.toString();
    }
	
	@GetMapping(path="/getAllOrders")
    public List<Order> getAllCustomerOrders(){
		
		ResponseEntity<List<Order>> response = restTemplate.exchange(
				  "http://localhost:8989/swiggy/getAllOrder",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Order>>(){});
				List<Order> orders = response.getBody();
				
		return orders;
		
	}
	
	@GetMapping(path="/postOrder")
    public String postOrder(){
		
		Item item1=new Item(101l, "Biriyani", 200.5,101L);
		Item item2=new Item(102l, "Roti", 400.5,103L);
		
		OrderTracking track1=new OrderTracking(101L, Arrays.asList("A","B","C","D"));
		List<Item> itemList=Arrays.asList(item1,item2);
		
		Restaurant restaurant1=new Restaurant(101L, "Royal Punjab", "Hadapsar",itemList);
		
		Order order1=new Order(1036L,"New Order 1",ORDERSTATUS.New,restaurant1, track1, APPRECIATION.Good);
		
		restTemplate.postForObject("http://localhost:8989/swiggy/addOrder",order1,Order.class);
		return "Created";
		
		
	}
}
