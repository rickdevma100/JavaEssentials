package com.example.SwiggyFoodServe.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.SwiggyFoodServe.model.APPRECIATION;
import com.example.SwiggyFoodServe.model.Item;
import com.example.SwiggyFoodServe.model.ORDERSTATUS;
import com.example.SwiggyFoodServe.model.Order;
import com.example.SwiggyFoodServe.model.OrderTracking;
import com.example.SwiggyFoodServe.model.Restaurant;

@Repository
public class OrderDaoImpl {
	
	private static List<Order> orderList=new ArrayList<>();
	
	static{
		
		Item item1=new Item(101l, "Biriyani", 200.5,101L);
		Item item2=new Item(102l, "Roti", 400.5,103L);
		Item item3=new Item(101l, "Veg Kolhapuri", 300.5,101L);
		Item item4=new Item(101l, "Veg Biriyani", 900.5,103L);
		Item item5=new Item(101l, "Dal Tadka", 600.5,102L);
		
		List<Item> itemList=Arrays.asList(item1,item3);		
		List<Item> itemList1=Arrays.asList(item2,item4);		
		List<Item> itemList2=Arrays.asList(item5,item5);
				
		Restaurant restaurant1=new Restaurant(101L, "Royal Punjab", "Hadapsar",itemList);
		Restaurant restaurant2=new Restaurant(102L,"Namaskar Bengali", "Destination Center",itemList2);
		Restaurant restaurant3=new Restaurant(103L,"Global Punjab", "Nigdi",itemList1);
		Restaurant restaurant4=new Restaurant(104L,"New Bengal", "Hadapsar",itemList);
		
		OrderTracking track1=new OrderTracking(101L, Arrays.asList("A","B","C","D"));
		OrderTracking track2=new OrderTracking(102L, Arrays.asList("A","B","C","D"));
		OrderTracking track3=new OrderTracking(103L, Arrays.asList("A","B","C","D"));
		OrderTracking track4=new OrderTracking(104L, Arrays.asList("A","B","C","D"));
		
		Order order1=new Order(101L,"New Order 1",ORDERSTATUS.New,restaurant1, track1, APPRECIATION.Good);
		
		Order order2=new Order(102L,"New Order 2",ORDERSTATUS.OnTheWay,restaurant4, track3, APPRECIATION.Poor);

		Order order3=new Order(103L,"New Order 3",ORDERSTATUS.Prepared,restaurant3, track2, APPRECIATION.VeryBad);
		
		Order order4=new Order(104L,"New Order 4",ORDERSTATUS.Prepared,restaurant2, track4, APPRECIATION.Avarage);

		//orderList=Arrays.asList(order1,order2,order3,order4);
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
	}
	public List<Order> findAll(){
		
		return orderList;		
	}
	
	public Order orderDetails(long id){
		
		Optional<Order> order=orderList
				.stream()
				.filter(x->x.getOrderId()==id)
				.map(x->x)
				.findFirst();	
		
		if(order.isPresent()){
			
			return order.get();
		}else{
			
			return null;
		}
		
	}
	
	public String orderTrackingDetails(long id, int index){
		
		return orderDetails(id)
				.getTrack()
				.getTrackLocation()
				.get(index);
	}
	
	public Order orderCancel(Order order){
		
		order.setOrderStatus(ORDERSTATUS.Canceled);	
		return order;
	}
	
	public Order orderAdd(Order order){
		
		orderList.add(order);	
		return order;
	}
	
}
