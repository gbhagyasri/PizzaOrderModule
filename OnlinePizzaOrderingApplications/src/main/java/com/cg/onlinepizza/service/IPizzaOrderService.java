package com.cg.onlinepizza.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.model.PizzaOrder;


public interface IPizzaOrderService {

		 PizzaOrder bookPizzaOrder(PizzaOrder order);
		  
		 PizzaOrder updatePizzaOrder(PizzaOrder order);
		 
		 PizzaOrder cancelPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException;
		 
		 Optional<PizzaOrder> viewPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException;
		 
		 List<PizzaOrder> viewOrdersList();
		 
		 List<PizzaOrder> viewOrdersListDate(LocalDate date);
		  
		// Optional<PizzaOrder> calculateTotal(String size, Integer quantity);
}

		 
	
