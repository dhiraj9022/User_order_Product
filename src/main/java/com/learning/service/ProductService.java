package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Order;
import com.learning.entity.Product;
import com.learning.exception.NotfoundException;
import com.learning.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public Product addProduct(Product product)
	{
		Product newProduct=new Product();
		newProduct.setPname(product.getPname());
		newProduct.setPrice(product.getPrice());
		newProduct.setPcode(product.getPcode());
		newProduct.setStock(product.getStock());
		return productRepo.save(newProduct);
	}
	
	public Iterable<Product> getAllProduct(){
		return productRepo.findAll();
	}
	
	public Product updateProduct(Product product, int pid)
	{
		Product updateProd=getProductById(pid);
		updateProd.setPcode(product.getPcode());
		updateProd.setPname(product.getPname());
		updateProd.setPrice(product.getPrice());
		updateProd.setStock(product.getStock());
		return productRepo.save(updateProd);
	}

	public Product getProductById(int pid) {
		
		return productRepo.findById(pid).orElseThrow(() ->new NotfoundException("Product Id not found"));
	}
}

