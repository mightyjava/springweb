package com.mightyjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mightyjava.model.User;
import com.mightyjava.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("/user/login");
		modelAndView.addObject("userForm", new User());
		return modelAndView;
	}
	
	@RequestMapping(value = "/authenticate")
	public ModelAndView authenticate(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		User userObj = userService.authenticate(user);
		if(userObj != null) {
			modelAndView.setViewName("/user/home");
		} else {
			modelAndView.setViewName("redirect:/user/login");
		}
		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView userList() {
		ModelAndView modelAndView = new ModelAndView("/user/list");
		modelAndView.addObject("users", userService.userList());
		return modelAndView;
	}
	
	@RequestMapping("/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("/user/add");
		modelAndView.addObject("userForm", new User());
		return modelAndView;
	}
	
	@RequestMapping(value = "/save")
	public ModelAndView saveUser(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		userService.saveUser(user);
		return modelAndView;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("/user/add");
		modelAndView.addObject("userForm", userService.findUser(id));
		return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteUser(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		userService.deleteUser(id);
		return modelAndView;
	}
}
