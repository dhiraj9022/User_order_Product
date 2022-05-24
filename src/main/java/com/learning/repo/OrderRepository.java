package com.learning.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Order;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer>{

}
