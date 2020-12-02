package com.cg.onlinepizza.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.model.PizzaOrder;
import com.cg.onlinepizza.repository.IPizzaOrderRepository;

	@Service("name=pizzaorderservice")
	@Transactional
	public class PizzaOrderServiceImpl implements IPizzaOrderService {

		@Autowired
		private IPizzaOrderRepository dao;
		
		@Override
		public PizzaOrder bookPizzaOrder(PizzaOrder order) {
			return dao.save(order);
		}
		@Override
		public PizzaOrder updatePizzaOrder(PizzaOrder order) {
			return dao.save(order);
		}
		@Override
		public PizzaOrder cancelPizzaOrder(Integer bookingOrderId){
			Optional<PizzaOrder> pizzaOrd=dao.findById(bookingOrderId);
			if(pizzaOrd.isEmpty())
			    throw new OrderIdNotFoundException("Enter a valid Order ID");
			dao.deleteById(bookingOrderId);
			return null;
		}
		@Override
		public Optional<PizzaOrder> viewPizzaOrder(Integer bookingOrderId) {
			 Optional<PizzaOrder> pizzaOrd=dao.findById(bookingOrderId);
			 if (pizzaOrd.isEmpty())
				 throw new OrderIdNotFoundException("Enter a valid Order ID");
			 return pizzaOrd;
		}
		@Override
		public List<PizzaOrder> viewOrdersList() {
			return dao.findAll();
			
		}
		@Override
		public List<PizzaOrder> viewOrdersListDate(LocalDate date) {		
			return dao.viewOrdersListDate(date);
		}
//		@Override
//		public Optional<PizzaOrder> calculateTotal(String size, Integer quantity) {
//			Optional<PizzaOrder> pizzaOrd=dao.calculateTotal(size, quantity);
//			 if (pizzaOrd.isEmpty())
//				 throw new InvalidSizeException("Enter valid Size");
//				 else
//			 return pizzaOrd;
//		}
//       
}
