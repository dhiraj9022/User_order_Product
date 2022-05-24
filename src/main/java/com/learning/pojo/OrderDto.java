package com.learning.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.learning.entity.OrderProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {

	private int oid;
	private int userId;
	private int total;
	private String status;
	private List<OrderProduct> orderProducts=new ArrayList<>();
}
