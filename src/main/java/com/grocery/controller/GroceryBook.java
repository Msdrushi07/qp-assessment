package com.grocery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.entity.Order;
import com.grocery.service.GroceryMethods;

@RestController
@RequestMapping("/order")
public class GroceryBook {

	@Autowired
	private GroceryMethods groceryMethods;

	@PostMapping
	public ResponseEntity<String> orderGroceries(@RequestBody List<Order> order) {
		String response = groceryMethods.orderGroceries(order);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
