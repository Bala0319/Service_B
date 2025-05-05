package com.example.Service_B.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FoodOrderEntityB {
	
	@Id
	private int foodOrderId;
	private String foodOrderName;
	private Double foodOrderPrice;
	private int foodOrderQuantity;


}
