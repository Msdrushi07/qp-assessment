package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.entity.Grocery;
import com.grocery.entity.Order;
import com.grocery.exception.NotFoundException;
import com.grocery.repository.GroceryRepository;
import com.grocery.repository.OrderRepository;

@Service
public class GroceryImplement implements GroceryMethods {

	@Autowired
	private GroceryRepository groceryRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public String addGrocery(Grocery grocery) {
		groceryRepository.save(grocery);
		return "Item saved successfully";
	}

	@Override
	public List<Grocery> getGroceries() {
		return groceryRepository.findAll();
	}

	@Override
	public String editGrocery(int id, Grocery grocery) throws NotFoundException {
		Grocery gr = groceryRepository.findById(id).get();
		if (gr == null) {
			throw new NotFoundException("Item not found");
		}
		gr.setName(grocery.getName());
		gr.setPrice(grocery.getPrice());
		return "Item updated successfully";
	}

	@Override
	public String deleteGrocery(int id) {
		groceryRepository.deleteById(id);
		return "Item deleted successfully";
	}

	@Override
	public String orderGroceries(List<Order> orders) {
		for (Order order : orders) {
			Grocery grocery = groceryRepository.findById(order.getGroceryId()).get();
			if (grocery != null) {
				int quantity = grocery.getQuantity();
				if (order.getQuantity() <= quantity) {
					orderRepository.save(order);
				}
			}
		}
		return "orders booked successfully";

	}

}
