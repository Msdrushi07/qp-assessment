package com.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.entity.Grocery;

public interface GroceryRepository extends JpaRepository<Grocery,Integer> {

}
