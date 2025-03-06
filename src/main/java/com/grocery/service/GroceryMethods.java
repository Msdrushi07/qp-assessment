package com.grocery.service;

import java.util.List;

import com.grocery.entity.Grocery;
import com.grocery.entity.Order;
import com.grocery.exception.NotFoundException;

public interface GroceryMethods {

	String addGrocery(Grocery grocery);

	List<Grocery> getGroceries();

	String deleteGrocery(int id);

	String editGrocery(int id, Grocery grocery) throws NotFoundException;

	String orderGroceries(List<Order> order);

	String gerGrocery(int id);

}
