package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

	private String login;
	private String password;
	private String name;
	private boolean online;

	private List<User> contacts;
	private List<Chat> chats;

	{
		contacts = new ArrayList<>();
		chats = new ArrayList<>();
	}

	public User(String login, String password, String name) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
	}

	public User() {

	}

	public List<User> getContacts() {
		return contacts;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public String isOnline() {
		if (online) {
			return "online";
		}
		return "offline";
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addContact(User contact) {
		if (contacts.add(contact)) {
			return true;
		}
		return false;
	}

	public boolean addChats(Chat chat) {
		if (chats.add(chat)) {
			return true;
		}
		return false;
	}

	public boolean removeContact(User contact) {
		if (contacts.remove(contact)) {
			return true;
		}
		return false;
	}
	
	public boolean removeChat(Chat chat) {
		if (chats.remove(chat)) {
			return true;
		}
		return false;
	}

	@Override public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chats == null) ? 0 : chats.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (online ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (chats == null) {
			if (other.chats != null)
				return false;
		} else if (!chats.equals(other.chats))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (online != other.online)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
