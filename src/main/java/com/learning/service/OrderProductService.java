package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.OrderProduct;
import com.learning.pojo.OrderProductDto;
import com.learning.repo.OrderProductRepository;

@Service
public class OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepo;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	public OrderProduct addOrderProduct(OrderProductDto orderProduct) {
		OrderProduct newOrderProduct=new OrderProduct();
		newOrderProduct.setDate_of_purchase(orderProduct.getDate_of_purchase());
		newOrderProduct.setOrder(orderService.getOrderById(orderProduct.getOrderId()));
		newOrderProduct.setProduct(productService.getProductById(orderProduct.getProductId()));
		return orderProductRepo.save(newOrderProduct);
	}
}
