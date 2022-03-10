package com.registration.registration.repository;

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
	    
	    ResponseEntity<User> response = restTemplate.exchange(
	            createUserUrl,
	            HttpMethod.POST,
	            request,
	            User.class);
	    
	    return response.getBody();
	}
}
