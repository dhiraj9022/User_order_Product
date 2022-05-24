package com.learning.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
