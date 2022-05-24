package com.learning.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private int total;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_Id", referencedColumnName = "uid")
	@JsonBackReference(value = "user-order")
	private User user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "orderProduct")
	private List<OrderProduct> orderProducts=new ArrayList<>();
}
