package com.learning.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.OrderProduct;
import com.learning.pojo.OrderProductDto;
import com.learning.service.OrderProductService;

@RestController
@RequestMapping("/api")
public class OrderProductController {

	@Autowired
	private OrderProductService orderProductService;

	@PostMapping("/addOrderProduct")
	@RolesAllowed("buyer")
	public OrderProduct addOrderProduct(@RequestBody OrderProductDto orderProduct)
	{
		return orderProductService.addOrderProduct(orderProduct);
	}
}
