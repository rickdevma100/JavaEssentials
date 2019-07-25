package com.example.SwiggyCustomer.model;

public class Order {

	private Long orderId;
	private String orderName;
	private ORDERSTATUS orderStatus;
	private Restaurant resteurant;
	private OrderTracking track;
	private APPRECIATION appreciation;
	
	public Order(){
		
		 super();
	}
	
	public Order(Long orderId, String orderName, ORDERSTATUS orderStatus, Restaurant resteurant, OrderTracking track,
			APPRECIATION appreciation) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderStatus = orderStatus;
		this.resteurant = resteurant;
		this.track = track;
		this.appreciation = appreciation;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * @return the orderStatus
	 */
	public ORDERSTATUS getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(ORDERSTATUS orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * @return the track
	 */
	public OrderTracking getTrack() {
		return track;
	}
	/**
	 * @param track the track to set
	 */
	public void setTrack(OrderTracking track) {
		this.track = track;
	}
	/**
	 * @return the resteurant
	 */
	public Restaurant getResteurant() {
		return resteurant;
	}
	/**
	 * @param resteurant the resteurant to set
	 */
	public void setResteurant(Restaurant resteurant) {
		this.resteurant = resteurant;
	}
	/**
	 * @return the appreciation
	 */
	public APPRECIATION getAppreciation() {
		return appreciation;
	}
	/**
	 * @param appreciation the appreciation to set
	 */
	public void setAppreciation(APPRECIATION appreciation) {
		this.appreciation = appreciation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderStatus=" + orderStatus
				+ ", resteurant=" + resteurant.toString() + ", track=" + track.toString() + ", appreciation=" + appreciation + "]";
	}
		
}
