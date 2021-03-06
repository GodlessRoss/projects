package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Serializable{

//	private int id;
	private String title;
	private String description;

	private List<User> users;
	private List<Message> messages;

	{
//		id = this.hashCode();
		users = new ArrayList<>();
		messages = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}

//	public List<Message> getMesages() {
//		return mesages;
//	}

//	public void setMesages(List<Message> mesages) {
//		this.mesages = mesages;
//	}

}
