package com.example.SwiggyFoodServe.model;

public class Customer {

	private Long custID;
	private String customerName;
	private String address;
	private Order order;
	
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @return the custID
	 */
	public Long getCustID() {
		return custID;
	}
	/**
	 * @param custID the custID to set
	 */
	public void setCustID(Long custID) {
		this.custID = custID;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	
	
}
