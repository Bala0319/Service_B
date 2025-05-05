package com.example.Service_B.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Service_B.entity.FoodOrderEntityB;

public interface FoodOrderRepositoryServiceB extends JpaRepository<FoodOrderEntityB, Integer> {

}
