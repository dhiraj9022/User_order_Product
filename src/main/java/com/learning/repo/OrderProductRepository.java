package com.learning.repo;

import org.springframework.data.repository.CrudRepository;

import com.learning.entity.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {

}
