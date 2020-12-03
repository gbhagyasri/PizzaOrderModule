package com.onlinepizza.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepizza.exceptions.OrderIdNotFoundException;
import com.onlinepizza.model.PizzaOrder;
import com.onlinepizza.repository.IPizzaOrderRepository;

	@Service("name=pizzaorderservice")
	@Transactional
	public class PizzaOrderServiceImpl implements IPizzaOrderService {

		@Autowired
		private IPizzaOrderRepository dao;
		
		/*
		 * Booking a PizzaOrder
		 */
		
		@Override
		public PizzaOrder bookPizzaOrder(PizzaOrder order) {
			return dao.save(order);
		}
		/*
		 * Updating a PizzaOrder
		 */
		
		@Override
		public PizzaOrder updatePizzaOrder(PizzaOrder order) {
			return dao.save(order);
		}
		
		/*
		 * Canceling a PizzaOrder by using Id
		 */
		
		@Override
		public PizzaOrder cancelPizzaOrder(Integer bookingOrderId){
			Optional<PizzaOrder> pizzaOrd=dao.findById(bookingOrderId);
			if(pizzaOrd.isEmpty())
			    throw new OrderIdNotFoundException("Enter a valid Order ID");
			dao.deleteById(bookingOrderId);
			return null;
		}
		/*
		 * Getting a PizzaOrder by using BookingOrderId
		 */
		
		@Override
		public Optional<PizzaOrder> viewPizzaOrder(Integer bookingOrderId) {
			 Optional<PizzaOrder> pizzaOrd=dao.findById(bookingOrderId);
			 if (pizzaOrd.isEmpty())
				 throw new OrderIdNotFoundException("Enter a valid Order ID");
			 return pizzaOrd;
		}
		/*
		 * Getting All Orders
		 */
		
		@Override
		public List<PizzaOrder> viewOrdersList() {
			return dao.findAll();
			
		}
		/* 
		 * Getting Orders by Date
		 */
		
		@Override
		public List<PizzaOrder> viewOrdersListDate(LocalDate date) {		
			return dao.viewOrdersListDate(date);
		}
		/*
		 * Calculating Total
		 */
		
		@Override
		public String calculateTotal(String size, double quantity) {
			return IPizzaOrderRepository.calculateTotal(size, quantity);
		}
       
}
