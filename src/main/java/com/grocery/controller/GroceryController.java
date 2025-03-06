package com.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.grocery.entity.Grocery;
import com.grocery.exception.NotFoundException;
import com.grocery.service.GroceryMethods;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

	@Autowired
	private GroceryMethods groceryMethods;

	@PostMapping
	public ResponseEntity<String> addGrocery(@RequestBody Grocery grocery) {
		String response = groceryMethods.addGrocery(grocery);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<String> getRrocery(@RequestParam("id") int id) {
		String response = groceryMethods.gerGrocery(id);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> editGrocery(@PathVariable("id") int id, @RequestBody Grocery grocery) throws NotFoundException {
		String response = groceryMethods.editGrocery(id, grocery);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGrocery(@PathVariable("id") int id) {
		String response = groceryMethods.deleteGrocery(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
