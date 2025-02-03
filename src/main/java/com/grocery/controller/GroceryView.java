package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.entity.Grocery;
import com.grocery.service.GroceryMethods;

@RestController
@RequestMapping("/view")
public class GroceryView {

	@Autowired
	private GroceryMethods groceryMethods;

	@GetMapping
	public ResponseEntity<List<Grocery>> getGroceries() {
		List<Grocery> response = groceryMethods.getGroceries();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
