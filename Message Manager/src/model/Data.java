package model;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
//	private static Data data;
	
	private static List<User> users;
	
//	public static Data getData() {
//		if (data == null) {
//			data = new Data();
//		}
//		return data;
//	}
//	
//	private Data() {
//		
//	}
	
	public static List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<>();
		}
		return users;
	}
	
}
