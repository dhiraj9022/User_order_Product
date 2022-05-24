package com.learning.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orderProducts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int opid;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date date_of_purchase;
	
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "oid")
	@JsonBackReference(value = "orderProduct")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "pid")
	@JsonBackReference(value = "productOrder")
	private Product product;
}
