package com.in28minutes.rest.webservices.restfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 0;
	
	
	
	static {
		users.add(new User(1,"Adam",new Date()));	
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
		
		usersCount = users.size();
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if( user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		User retUser = null;
		while ( iterator.hasNext()) {
			User t = iterator.next();
			if( t.getId()==id) {
				iterator.remove();
				retUser = t;
			}
		}
		return retUser ;
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User Save(User user) {
		if(user.getId()==null)
			user.setId(++usersCount);
		
		users.add(user);
		return user;
	}	
	
}
