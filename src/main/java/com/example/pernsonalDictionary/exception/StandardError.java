package com.example.pernsonalDictionary.exception;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	//private St status;
	private String message;
	private Date timeStamp;
	
	public StandardError(String message, Date timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
}