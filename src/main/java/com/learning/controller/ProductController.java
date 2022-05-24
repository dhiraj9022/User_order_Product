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

import com.learning.entity.Product;
import com.learning.entity.User;
import com.learning.pojo.UserDto;
import com.learning.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	@RolesAllowed("seller")
	public Product createProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@PutMapping("/updateProduct/{pid}")
	@RolesAllowed("seller")
	public Product updateProduct(@RequestBody Product product, @PathVariable int pid)
	{
		return productService.updateProduct(product,pid);
	}
	
	@GetMapping("/getProduct")
	@RolesAllowed("seller")
	public Iterable<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	@GetMapping("/{pid}")
	@RolesAllowed("seller")
	public Product getProductById(@PathVariable int pid)
	{
		return productService.getProductById(pid);
	}
}
