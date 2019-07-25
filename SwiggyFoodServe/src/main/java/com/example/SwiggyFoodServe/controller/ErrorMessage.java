package com.example.SwiggyFoodServe.controller;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private Date date;
	private String errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
		
	
	
	public ErrorMessage(Date date, String errorCode, String documentation) {
		super();
		this.date = date;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
