package model;

import java.io.Serializable;

public class Task implements Serializable {

	private String title;
	private String description;
	private byte priority;

//	private DateTime createTask;
//	private DateTime completion time;
//	private String executor;
	
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

	public byte getPriority() {
		return priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

	public Task(String title, String description, byte priority) {
		super();
		this.title = title;
		this.description = description;
		this.priority = priority;
	}

}
