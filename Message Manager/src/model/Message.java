package model;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable{
	
	private String text;
	private User sender;
	private Chat room;
	private boolean readed;
//	private boolean sended;
//	private DateTime timeSend;
	
//	private List<User> receivers;
	
	{
//		id = this.hashCode();
		readed = false;
	}
	

//	public int getId() {
//		return id;
//	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Chat getRoom() {
		return room;
	}

	public void setRoom(Chat room) {
		this.room = room;
	}

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	
	
	
}
