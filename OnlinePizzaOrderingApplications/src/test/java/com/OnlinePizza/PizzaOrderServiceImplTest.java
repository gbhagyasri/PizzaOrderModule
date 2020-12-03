package com.OnlinePizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onlinepizza.exceptions.OrderIdNotFoundException;
import com.onlinepizza.model.Coupan;
import com.onlinepizza.model.Order;
import com.onlinepizza.model.Pizza;
import com.onlinepizza.model.PizzaOrder;
import com.onlinepizza.repository.IPizzaOrderRepository;
import com.onlinepizza.service.PizzaOrderServiceImpl;

import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class PizzaOrderServiceImplTest {
	
	@InjectMocks
	private PizzaOrderServiceImpl pizzaorderService;
	
	@Mock
	private IPizzaOrderRepository pizzaorderRepository;

	private Pizza pizza;

	private List<Pizza> pizzaList;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	 void bookPizzaOrderTest() {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9), pizzaList,order2,coupan);

		when(pizzaorderRepository.save(pOrder)).thenReturn(pOrder);
		
		pOrder = pizzaorderService.bookPizzaOrder(pOrder);
		
		assertEquals("Medium", pOrder.getSize1());
		verify(pizzaorderRepository, times(1)).save(pOrder);

	}

	@Test
	 void updatePizzaOrderTest() {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizzaList,order2,coupan);
		
		when(pizzaorderRepository.save(pOrder)).thenReturn(pOrder);
		
		pOrder.setTransactionMode("Cash on Delivery");
		
		pOrder = pizzaorderService.updatePizzaOrder(pOrder);
		
		assertEquals("Cash on Delivery", pOrder.getTransactionMode());
		verify(pizzaorderRepository, times(1)).save(pOrder);
	}
	@Test
	 void cancelPizzaOrderTest() throws OrderIdNotFoundException {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizzaList,order2,coupan);
		
		
		Integer bookingOrderId = pOrder.getBookingOrderId();
		Optional<PizzaOrder> PizzaOrd = Optional.of(pOrder);
		when(pizzaorderRepository.findById(bookingOrderId)).thenReturn(PizzaOrd);
		
		pOrder = pizzaorderService.cancelPizzaOrder(bookingOrderId);
		
		assertNull(pOrder);
		verify(pizzaorderRepository, times(1)).deleteById(bookingOrderId);
	}
	@Test
	 void viewPizzaOrderTest() throws OrderIdNotFoundException {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizzaList,order2,coupan);
		Integer bookingOrderId = pOrder.getBookingOrderId();
		Optional<PizzaOrder> PizzaOrd = Optional.of(pOrder);
		when(pizzaorderRepository.findById(bookingOrderId)).thenReturn(PizzaOrd);
		
		Optional<PizzaOrder> viewPizzaOrder = pizzaorderService.viewPizzaOrder(bookingOrderId);
		
		assertEquals("Medium", viewPizzaOrder.get().getSize1());
		verify(pizzaorderRepository, times(2)).findById(bookingOrderId);
	}
	@Test
	 void viewOrdersListTest() {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		List<PizzaOrder> ordersList = new ArrayList<PizzaOrder>();
		ordersList.add(new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(2020,01,9),pizzaList,order2,coupan));
		ordersList.add(new PizzaOrder("small",15,546.79D, "cash on delivery",LocalDate.of(2010,03,21),pizzaList,order2,coupan));
		ordersList.add(new PizzaOrder("Large",2,100.00D, "online",LocalDate.of(1999,01,9),pizzaList,order2,coupan));
		when(pizzaorderRepository.findAll()).thenReturn(ordersList);
		
		List<PizzaOrder> pizzaOrdList = pizzaorderService.viewOrdersList();
		
		assertEquals(3, pizzaOrdList.size());
		verify(pizzaorderRepository, times(1)).findAll();
	}
	
}
