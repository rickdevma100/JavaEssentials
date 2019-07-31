package com.example.SwiggyFoodServe.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.SwiggyFoodServe.dao.OrderDaoImpl;
import com.example.SwiggyFoodServe.dao.RestaurantDaoImpl;
import com.example.SwiggyFoodServe.model.Item;
import com.example.SwiggyFoodServe.model.Order;
import com.example.SwiggyFoodServe.model.Restaurant;

@RestController
@RequestMapping(value="/swiggy")
public class SwiggyController {

	private static final Logger logger = LoggerFactory.getLogger(SwiggyController.class);
	@Autowired
	private OrderDaoImpl orderImpl;
	@Autowired
	private RestaurantDaoImpl restaurantDao;
	 
	@GetMapping(path="/orders")
    public List<Order> getAllOrders() {
		logger.info("Get All order Details ");
		return orderImpl.findAll();

    }
	
	@GetMapping(path="/order/{id}")
    public Order getOrder(@PathVariable long id) {
		logger.info("Get Order Details for "+id);		
		Order order=orderImpl.orderDetails(id);
		
		if(order==null){
			 throw new OrderNotFoundException("Order Not Found..");
		}		
		return order;
    }
	
	@GetMapping(path="/restaurants")
	public List<Restaurant> getAllRestaurants(){	
		logger.info("Get All Restaurant Details ");
		return restaurantDao.findAll();
				
	}
	
	@GetMapping(path="/restaurant/{id}/items")
	public List<Item> getRestaurantItems(@PathVariable long id){		
		List<Item> items= restaurantDao.itemDetails(id);
		logger.info("Get Items for a restaurant id "+id);
		if(items==null){
			 throw new RestaurantNotFoundException("Restaurant Not Found..");
		}		
		return items;
	}
	
	@PostMapping("/order/add")
	public ResponseEntity<Object> createOrder(@RequestBody Order order){		
		Order savedOrder=orderImpl.orderAdd(order);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrder.getOrderId()).toUri();	
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/cancelOrder/{id}")
	public ResponseEntity<Object> cancelOrder(@PathVariable long id)
	{		
		Order order=orderImpl.orderDetails(id);
		Order canceledOrder=orderImpl.orderCancel(order);
		if(canceledOrder==null){
			 throw new OrderNotFoundException("Order Not Found..");
		}	
		
		return ResponseEntity.ok(canceledOrder);
	}
	
}
