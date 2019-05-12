package com.vineetha.application.messengerApplication.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//model class to get the instances of message
@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	
	
	public Message() {
		
	}

	//	constructor
	public Message(long id, String message,String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
//	getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
