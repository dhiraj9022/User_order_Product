package com.learning.controller;

import javax.annotation.security.RolesAllowed;

import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Order;
import com.learning.entity.User;
import com.learning.pojo.OrderDto;
import com.learning.service.OrderService;
import com.learning.service.UserService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;
	
	@PostMapping("/addOrder")
	@RolesAllowed("buyer")
	public Order createOrder(@RequestBody OrderDto order)
	{
		System.out.println(userService.getUserById(order.getUserId()));
		return orderService.placeOrder(order);
	}
	
	@PutMapping("/updateOrder/{oid}")
	@RolesAllowed("buyer")
	public Order updateOrder(@RequestBody OrderDto order, @PathVariable int oid)
	{
		return orderService.updateOrder(order,oid);
	}
	
	@GetMapping("/getOrder/{oid}")
	public Order getOrder(@PathVariable int oid)
	{
		return orderService.getOrderById(oid);
	}
	
	@GetMapping("/getOrders")
	@RolesAllowed("buyer")
	public Iterable<Order> getAllOrders()
	{
		return orderService.getAll();
	}


}
