package com.example.Service_B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_B.ServiceInter.FoodOrderServiceInterServiceB;
import com.example.Service_B.dto.FoodOrderDtoB;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class FoodOrderControllerServiceB {
	
	@Autowired
	FoodOrderServiceInterServiceB foodOrderServiceInterServiceB;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@PostMapping("/saveFoodOrderB")
	public FoodOrderDtoB saveFoodOrderB(@RequestBody FoodOrderDtoB foodOrderDtoB) {
		
		log.info("Received request to save FoodOrder: {}", foodOrderDtoB);

		foodOrderDtoB = foodOrderServiceInterServiceB.saveFoodOrderB(foodOrderDtoB);
		
		log.info("FoodOrder saved successfully: {}", foodOrderDtoB);

		return foodOrderDtoB;
	}

}
