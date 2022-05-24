package com.learning.pojo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderProductDto {
	
	private int opid;
	private int orderId;
	private int productId;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date date_of_purchase;
}
