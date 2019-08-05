package com.swiggy.resturant.OrderConsumer.model;

import java.io.Serializable;

public enum ORDERSTATUS implements Serializable{

	New,
	Preparing,
	Prepared,
	ReadyToDeliver,
	OnTheWay,
	Delivered,
	Canceled
}
