package com.registration.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.registration.model.User;
import com.registration.registration.repository.UserProxy;

import lombok.Data;

@Data
@Service
public class UserService {
	
	@Autowired
    private UserProxy userProxy;

    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }
    
    public User registreUsers(User user) {
        System.out.println("######### 3  ==>> 1");
    	User savedUser = null;
    	System.out.println("######### 3  ==>> 2");
        if(user.getId() == null) {
        	System.out.println("######### 3  ==>> 3");
        	savedUser = userProxy.registreUser(user);
        	System.out.println("######### 3  ==>> 4");
        }
        System.out.println("######### 3  ==>> 5");
        return savedUser;
    }
    
    public User getUser(final Long long1) {
		return this.userProxy.getUser(long1);
	}
    
    public void deleteUser(final int id) {
		userProxy.deleteUser(id);
	}
}
