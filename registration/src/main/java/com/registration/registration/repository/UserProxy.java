package com.registration.registration.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.registration.registration.CustomProperties;
import com.registration.registration.model.User;

import lombok.extern.slf4j.Slf4j;
import com.registration.registration.model.Model;
@Slf4j
@Component
public class UserProxy {

	@Autowired
    private CustomProperties props;
	
	public Iterable<User> getUsers() {
		String baseApiUrl = props.getApiUrl();
        String getUsersUrl = baseApiUrl + "/users";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
        		getUsersUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<User>>() {}
			);
        
        return response.getBody();
	}
	
	public User registreUser(User user) {
		String baseApiUrl = props.getApiUrl();
	    String createUserUrl = baseApiUrl + "/user";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    HttpEntity<User> request = new HttpEntity<User>(user);
	    System.out.println("######### 3  ==>> 3    ===+>>>> 1");
	    System.out.println(user.getFirstName());
	    System.out.println(user.getLastName());
	    System.out.println(user.getMail());
	    System.out.println(user.getPassword());
	    ResponseEntity<User> response = restTemplate.exchange(
	            createUserUrl,
	            HttpMethod.POST,
	            request,
	            User.class);
	    System.out.println("######### 3  ==>> 3    ===+>>>> 2");
	    return response.getBody();
	}
	
	public User getUser(Long long1) {
		String baseApiUrl = props.getApiUrl();
		String getUserUrl = baseApiUrl + "/user/" + long1;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.exchange(
				getUserUrl, 
				HttpMethod.GET, 
				null,
				User.class
			);
		
		return response.getBody();
	}
	
	public User updateUser(User user) {
		String baseApiUrl = props.getApiUrl();
		String updateUserUrl = baseApiUrl + "/user/" + user.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<User>(user);
		ResponseEntity<User> response = restTemplate.exchange(
				updateUserUrl, 
				HttpMethod.PUT, 
				request, 
				User.class);
		
		return response.getBody();
	}
	
	public void deleteUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteUserUrl = baseApiUrl + "/user/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteUserUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
	}
}
