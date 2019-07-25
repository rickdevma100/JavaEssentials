package com.example.SwiggyFoodServe.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.SwiggyFoodServe.model.Item;
import com.example.SwiggyFoodServe.model.Restaurant;

@Repository
public class RestaurantDaoImpl {

	private static List<Restaurant> restaurantList=new ArrayList<>();
	
	static{
		
		Item item1=new Item(101l, "Biriyani", 200.5,101L);
		Item item2=new Item(102l, "Roti", 400.5,103L);
		Item item3=new Item(103l, "Veg Kolhapuri", 300.5,101L);
		Item item4=new Item(104l, "Veg Biriyani", 900.5,103L);
		Item item5=new Item(105l, "Dal Tadka", 600.5,102L);
		
		List<Item> itemList=Arrays.asList(item1,item3);		
		List<Item> itemList1=Arrays.asList(item2,item4);		
		List<Item> itemList2=Arrays.asList(item5);
				
		Restaurant restaurant1=new Restaurant(101L, "Royal Punjab", "Hadapsar",itemList);
		Restaurant restaurant2=new Restaurant(102L,"Namaskar Bengali", "Destination Center",itemList2);
		Restaurant restaurant3=new Restaurant(103L,"Global Punjab", "Nigdi",itemList1);
		Restaurant restaurant4=new Restaurant(104L,"New Bengal", "Hadapsar",itemList);
		
		restaurantList=Arrays.asList(restaurant1,restaurant2,restaurant3,restaurant4);
	}
	
	public List<Restaurant> findAll(){
		
		return restaurantList;		
	}
	
	public List<Item> itemDetails(long id){
		
		Optional<List<Item>> items=restaurantList.stream()
				.filter(x->x.getId()==id)
				.map(x->x.getItems())
				.findFirst();
		
		if(items.isPresent()){
			
			return items.get();
		}else{
			
			return null;
		}
		
		
	}
}
