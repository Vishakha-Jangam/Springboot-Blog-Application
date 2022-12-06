package com.masai.springboot_blogApp.DTO;

import java.util.Date;

public class ErrorDetails {

	private Date timeStamp;
	private String message;
	private String deatils;
	
	public ErrorDetails(Date timeStamp, String message, String deatils) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.deatils = deatils;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDeatils() {
		return deatils;
	}
	
	
	
	
}
