package com.example.Service_B.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.Service_B.ServiceInter.FoodOrderServiceInterServiceB;
import com.example.Service_B.dto.FoodOrderDtoB;
import com.example.Service_B.entity.FoodOrderEntityB;
import com.example.Service_B.repository.FoodOrderRepositoryServiceB;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FoodOrderServiceImplServiceB implements FoodOrderServiceInterServiceB {
	
	@Autowired
	FoodOrderRepositoryServiceB foodOrderRepositoryServiceB;
	
	@Autowired
	RestTemplate restTemplate;

	// 63820 59006
	@Autowired
	private ModelMapper modelMapper;
	
	public FoodOrderDtoB saveFoodOrderB(FoodOrderDtoB foodOrderDtoB) {
		
		log.info("Starting to save Food Order in DB: {}", foodOrderDtoB);

		foodOrderRepositoryServiceB.save(convertDtoToEntity(foodOrderDtoB));
		
		log.info("Food Order saved in DB: {}", foodOrderDtoB);

		FoodOrderDtoB foodOrderResponse =restTemplate.postForEntity("http://localhost:8890/saveFoodOrderA", foodOrderDtoB, FoodOrderDtoB.class).getBody();
		
		log.info("Response received from Service A: {}", foodOrderResponse);

		return foodOrderResponse;
	}
	
	public FoodOrderDtoB convertEntityToDto(FoodOrderEntityB foodOrderEntityB) {
		return modelMapper.map(foodOrderEntityB, FoodOrderDtoB.class);
	}
	
	public FoodOrderEntityB convertDtoToEntity(FoodOrderDtoB foodOrderDtoB) {
		return modelMapper.map(foodOrderDtoB, FoodOrderEntityB.class);
	}


}
