package com.example.SwiggyFoodServe.model;

public class Customer {

	private Long custID;
	private String customerName;
	private String address;
	
	
	
	public Customer(Long custID, String customerName, String address) {
		super();
		this.custID = custID;
		this.customerName = customerName;
		this.address = address;
		
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
