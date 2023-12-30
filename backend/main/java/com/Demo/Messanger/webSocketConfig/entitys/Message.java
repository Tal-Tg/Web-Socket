package com.Demo.Messanger.webSocketConfig.entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	
//	private static List<Message> messages = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String message;
	
	
	
	
	
	public Message() {
		super();
	}

	public Message( String message) {
		super();
		this.message = message;
	}

	public Message(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}
	
	
	
	
	
	
}
