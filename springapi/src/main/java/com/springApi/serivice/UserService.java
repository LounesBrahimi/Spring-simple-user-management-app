package com.springApi.serivice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApi.model.User;
import com.springApi.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getUsers(final Long id){
		return userRepository.findById(id);
	}
	
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    
    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
    
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}