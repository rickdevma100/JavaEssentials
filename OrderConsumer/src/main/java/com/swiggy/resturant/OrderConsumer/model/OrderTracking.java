package com.swiggy.resturant.OrderConsumer.model;

import java.io.Serializable;
import java.util.List;

public class OrderTracking implements Serializable {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	private long trackingId;
	private List<String> trackLocation;
	
	public OrderTracking(){
		 super();
	}
	
	public OrderTracking(long trackingId, List<String> trackLocation) {
		super();
		this.trackingId = trackingId;
		this.trackLocation = trackLocation;
	}
	/**
	 * @return the trackingId
	 */
	public long getTrackingId() {
		return trackingId;
	}
	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(long trackingId) {
		this.trackingId = trackingId;
	}
	/**
	 * @return the trackLocation
	 */
	public List<String> getTrackLocation() {
		return trackLocation;
	}
	/**
	 * @param trackLocation the trackLocation to set
	 */
	public void setTrackLocation(List<String> trackLocation) {
		this.trackLocation = trackLocation;
	}
	
	@Override
	public String toString() {
		return "OrderTracking [trackingId=" + trackingId + ", trackLocation=" + trackLocation + "]";
	}
	
}
