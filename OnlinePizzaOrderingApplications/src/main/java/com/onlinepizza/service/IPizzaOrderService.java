package com.onlinepizza.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.onlinepizza.model.PizzaOrder;


public interface IPizzaOrderService {

		 PizzaOrder bookPizzaOrder(PizzaOrder order);
		  
		 PizzaOrder updatePizzaOrder(PizzaOrder order);
		 
		 PizzaOrder cancelPizzaOrder(Integer bookingOrderId) ;
		 
		 Optional<PizzaOrder> viewPizzaOrder(Integer bookingOrderId) ;
		 
		 List<PizzaOrder> viewOrdersList();
		 
		 List<PizzaOrder> viewOrdersListDate(LocalDate date);
		  
		String calculateTotal(String size, double quantity);
}

		 
	
