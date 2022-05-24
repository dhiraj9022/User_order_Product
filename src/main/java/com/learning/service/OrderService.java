package com.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Order;
import com.learning.entity.Product;
import com.learning.entity.User;
import com.learning.exception.NotfoundException;
import com.learning.pojo.OrderDto;
import com.learning.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserService userService;
	
	public Order placeOrder(OrderDto order) {
		
		Order newOrder=new Order();
		newOrder.setTotal(order.getTotal());
		newOrder.setStatus(order.getStatus());
		newOrder.setUser(userService.getUserById(order.getUserId()));
		return orderRepo.save(newOrder);
	}
	
	public Order getOrderById(int oid)
	{
		return orderRepo.findById(oid).orElseThrow(() -> new NotfoundException("Order Id not found !!"));
	}
	
	public Order updateOrder(OrderDto order, int oid) {
		Order updateOrder=getOrderById(oid);
		updateOrder.setTotal(order.getTotal());
		updateOrder.setStatus(order.getStatus());
		return orderRepo.save(updateOrder);
	}
	
	public Iterable<Order> getAll() {
		List<Order> orders = new ArrayList<>();
		orderRepo.findAll().forEach(o->orders.add(o));
		 return orders;
	}
}
