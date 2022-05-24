package com.learning.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.User;
import com.learning.pojo.UserDto;
import com.learning.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	@RolesAllowed("admin")
	public User createUser(@RequestBody UserDto user)
	{
		return userService.addUser(user);
	}
	
	@PutMapping("/updateUser/{uid}")
	@RolesAllowed("admin")
	public User updateUser(@RequestBody UserDto user, @PathVariable int uid)
	{
		return userService.updateUser(user,uid);
	}
	
	@GetMapping("/getUser/{uid}")
	@RolesAllowed("admin")
	public User getUser(@PathVariable int uid)
	{
		return userService.getUserById(uid);
	}
	
	@GetMapping("/getUsers")
	@RolesAllowed("admin")
	public Iterable<User> getAllUser()
	{
		return userService.getAll();
	}


}
