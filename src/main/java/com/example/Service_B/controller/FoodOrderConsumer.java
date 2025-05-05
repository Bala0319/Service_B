package com.example.Service_B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.Service_B.dto.FoodOrderDtoB;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FoodOrderConsumer {
	
	@Autowired
	ObjectMapper objectMapper;

	@KafkaListener(topics = "food-order-service",groupId = "My_Group")
	public void saveFoodOrder(String foodOrderDto) {
		
		log.info("Received message from Kafka topic 'FoodOrderService': {}", foodOrderDto);

		try {
			FoodOrderDtoB foodOrderDtoB =objectMapper.readValue(foodOrderDto, FoodOrderDtoB.class);
			
			log.info("Successfully deserialized Kafka message to FoodOrderDtoB: {}", foodOrderDtoB);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
