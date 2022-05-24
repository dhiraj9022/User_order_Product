package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.entity.User;
import com.learning.exception.NotfoundException;
import com.learning.pojo.UserDto;
import com.learning.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User addUser(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setMobile(user.getMobile());
		return userRepo.save(newUser);
	}

	public User getUserById(int uid) {
		return userRepo.findById(uid).orElseThrow(() -> new NotfoundException("User Id not found !!"));
	}

	public User updateUser(UserDto user, int uid) {
		User updateUser = getUserById(uid);
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
		updateUser.setEmail(user.getEmail());
		updateUser.setMobile(user.getMobile());
		return userRepo.save(updateUser);
	}

	public Iterable<User> getAll() {
	//	List<User> users = new ArrayList<>();
//		 userRepo.findAll().forEach(u ->{
//			 List<Product> products=new ArrayList<>();
//			 userRepo.findAll().forEach(p->products.add(p));
//		 });
//		userRepo.findAll().forEach(u->{
//			List<Order> orders=new ArrayList<>();
//			orderRepo.findAll().forEach(o->{
//				List<Product> products=new ArrayList<>();
//				productRepo.findAll().forEach(products::add);
//				orders.add(o);
//			});
//			users.add(u);
//		});
		 return userRepo.findAll();
	}
}
