package com.swiggy.resturant.OrderConsumer.model;

import java.io.Serializable;

public class Item  implements Serializable{

	private long id;
	private String name;
	private double amount;
	private long restaurantId;

	public Item(){
		 super();
	}
	
	public Item(long id, String name, double amount, long restaurantId) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.setRestaurantId(restaurantId);
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the restaurantId
	 */
	public long getRestaurantId() {
		return restaurantId;
	}
	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	
}
