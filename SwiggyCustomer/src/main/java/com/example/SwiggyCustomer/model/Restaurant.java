package com.example.SwiggyCustomer.model;

import java.util.List;

public class Restaurant {
	
	private long id;
	private String name;
	private String address;
	private List<Item> items;

	public Restaurant(){
		 super();
	}
	
	public Restaurant(long id, String name, String address, List<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.items = items;
		
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the item
	 */
	public List<Item> getItems() {
		return items;
	}
	/**
	 * @param item the item to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", items=" + items.toString() + "]";
	}	

}
