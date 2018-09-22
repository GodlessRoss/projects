package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import model.Chat;
import model.User;

public final class JarUsers {

	private static JarUsers jarUs;

	private static File usersData;
	private static List<User> users;

	private static boolean start() {
		if (!downloadData()) {
			return false;
		}
		return true;
	}

	public static JarUsers run() {
		if (jarUs == null) {
			if (start()) {
				jarUs = new JarUsers();
			}
		}
		return jarUs;
	}

	private JarUsers() {
	}

	private static boolean downloadData() {
		try {
			usersData = new File("users.data");
			if (!usersData.exists()) {
				usersData.createNewFile();
			}
			readFile();
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден\nЗавершение программы");
			return false;
		} catch (IOException e) {
			System.out.println("Данные получены.");
			if (users == null) {
				users.add(new User());
			}
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e);
			return false;
		}
		return false;
	}

	public boolean add(User user) {
		if (!repeatCheck(user)) {
			if (users.add(user)) {
				write();
				return true;
			}
		}
		return false;
	}

	private boolean repeatCheck(User user) {
		for (User u : users) {
			if (u != null && u.getLogin().equals(user.getLogin()) || u.getName().equals(user.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(User user) {
		if (users.remove(user)) {
			return true;
		}
		return false;
	}

	public boolean serarch(User user) {
		for (User u : users) {
			if (u != null && u.equals(user)) {
				return true;
			}
		}
		return false;
	}

	public boolean serarch(String log, String pass) {
		for (User u : users) {
			if (u != null && u.getLogin().equals(log) && u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public void close() { write(); }
	 */

	public void write() {
		ObjectOutputStream writer = null;
		try {
			writer = new ObjectOutputStream(new FileOutputStream(usersData));
			for (User task : users) {
				writer.writeObject(task);
			}
			System.out.println("Данные сохранены.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}
		}
	}

	private static void readFile() throws ClassNotFoundException, FileNotFoundException, IOException {
		users = new ArrayList<>();
		User temp = createDefaultUser();
		users.add(temp);
		ObjectInputStream reader = new ObjectInputStream(new FileInputStream(usersData));
		try {
			while (true) {
				users.add((User) reader.readObject());
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	
	// test
	private static User createDefaultUser() {
		User tempUser = new User();
		tempUser.setLogin("admin");
		tempUser.setPassword("admin");
		tempUser.setName("default");
		
		Chat tempChat = new Chat();
		tempChat.setTitle("Test");
		tempChat.addUser(tempUser);
		
		tempUser.addChats(tempChat);
		tempUser.addChats(tempChat);
			
		tempUser.addContact(tempUser);
		tempUser.addContact(tempUser);

		return tempUser;
	}

	public User getUserForLog(String text) {
		for (User user : users) {
			if (user != null && user.getLogin() != null && user.getLogin().equals(text)) {
				return user;
			}
		}
		return null;
	}
}
