package com.registration.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registration.registration.model.User;
import com.registration.registration.service.UserService;
import org.springframework.ui.Model;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String home(Model model) {
	    Iterable<User> listUsers = service.getUsers();
	    model.addAttribute("users", listUsers);
	    return "home";
	}
	
	@GetMapping("/registreUser")
	public String registreUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "formNewUser";
	}
	
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") final long id, Model model) {
		User user = service.getUser(id);		
		model.addAttribute("user", user);	
		return "formUpdateUser";		
	}
	
	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") final int id) {
		service.deleteUser(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveUser")
	public ModelAndView saveEmployee(@ModelAttribute User user) {
		System.out.println("######## 1");
		if(user.getId() != null) {System.out.println("######## 2");
			User current = service.getUser(user.getId());
			user.setPassword(current.getPassword());
		}System.out.println("######## 3");
		service.registreUsers(user);
		System.out.println("######## 4");
		return new ModelAndView("redirect:/");	
	}
}
