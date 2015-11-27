package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import com.yash.User;

public class Service {

	static List<User> userList=new ArrayList<User>();

	public static void add(User user) {
		userList.add(user);
	}

	public static List<User> get() {
		return userList;
	}

	public static boolean update(User user) {
		boolean flag=false;
		for(User u:userList) {

			if(u.getId()==user.getId()) {
				u.setName(user.getName());
				u.setAddress(user.getAddress());
				u.setContact(user.getContact());
				flag=true;
				break;
			}
		}
		return flag;
	}


	public static boolean delete(User user) {
		boolean flag=false;

		for(User u:userList) {

			if(u.getId()==user.getId()) {
				u.setName(user.getName());
				u.setAddress(user.getAddress());
				u.setContact(user.getContact());
				userList.remove(u);
				flag=true;
				break;
			}
		}
		return flag;
	}
}
