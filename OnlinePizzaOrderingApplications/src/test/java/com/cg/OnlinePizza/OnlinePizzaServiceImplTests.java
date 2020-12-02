package com.cg.OnlinePizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.model.Coupan;
import com.cg.onlinepizza.model.Order;
import com.cg.onlinepizza.model.Pizza;
import com.cg.onlinepizza.model.PizzaOrder;
import com.cg.onlinepizza.repository.IPizzaOrderRepository;
import com.cg.onlinepizza.service.PizzaOrderServiceImpl;

import ch.qos.logback.core.spi.LifeCycle;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class OnlinePizzaServiceImplTests {
	
	@InjectMocks
	private PizzaOrderServiceImpl pizzaorderService;
	
	@Mock
	private IPizzaOrderRepository pizzaorderRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	 void bookPizzaOrderTest() {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		PizzaOrder Piz = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizza,order2,coupan);

		when(pizzaorderRepository.save(Piz)).thenReturn(Piz);
		
		Piz = pizzaorderService.bookPizzaOrder(Piz);
		
		assertEquals("Medium", Piz.getSize1());
		verify(pizzaorderRepository, times(1)).save(Piz);

	}

	@Test
	 void updatePizzaOrderTest() {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		PizzaOrder Piz = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizza,order2,coupan);
		
		when(pizzaorderRepository.save(Piz)).thenReturn(Piz);
		
		Piz.setTransactionMode("Cash on Delivery");
		
		Piz = pizzaorderService.updatePizzaOrder(Piz);
		
		assertEquals("Cash on Delivery", Piz.getTransactionMode());
		verify(pizzaorderRepository, times(1)).save(Piz);
	}
	@Test
	 void cancelPizzaOrderTest() throws OrderIdNotFoundException {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		PizzaOrder Piz = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizza,order2,coupan);
		
		
		Integer bookingOrderId = Piz.getBookingOrderId();
		Optional<PizzaOrder> PizzaOrd = Optional.of(Piz);
		when(pizzaorderRepository.findById(bookingOrderId)).thenReturn(PizzaOrd);
		
		Piz = pizzaorderService.cancelPizzaOrder(bookingOrderId);
		
		assertNull(Piz);
		verify(pizzaorderRepository, times(1)).deleteById(bookingOrderId);
	}
	@Test
	 void viewPizzaOrderTest() throws OrderIdNotFoundException {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		PizzaOrder Piz = new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(1999,01,9),pizza,order2,coupan);
		Integer bookingOrderId = Piz.getBookingOrderId();
		Optional<PizzaOrder> PizzaOrd = Optional.of(Piz);
		when(pizzaorderRepository.findById(bookingOrderId)).thenReturn(PizzaOrd);
		
		Optional<PizzaOrder> viewPizzaOrder = pizzaorderService.viewPizzaOrder(bookingOrderId);
		
		assertEquals("Medium", viewPizzaOrder.get().getSize1());;
		verify(pizzaorderRepository, times(2)).findById(bookingOrderId);
	}
	@Test
	 void viewOrdersListTest() {
		Coupan coupan=new Coupan("Extra50%","discount","Reduces 50% of bill");
		Order order2=new Order("Onlineorder","1 pizza",77); 
		Pizza pizza=new Pizza("Vegetarian","Margherita","made with Mozzorella cheese",345.76D,234.98D);
		List<PizzaOrder> ordersList = new ArrayList<PizzaOrder>();
		ordersList.add(new PizzaOrder("Medium",12,456.78D, "online",LocalDate.of(2020,01,9),pizza,order2,coupan));
		ordersList.add(new PizzaOrder("small",15,546.79D, "cash on delivery",LocalDate.of(2010,03,21),pizza,order2,coupan));
		ordersList.add(new PizzaOrder("Large",2,100.00D, "online",LocalDate.of(1999,01,9),pizza,order2,coupan));
		when(pizzaorderRepository.findAll()).thenReturn(ordersList);
		
		List<PizzaOrder> pizzaOrdList = pizzaorderService.viewOrdersList();
		
		assertEquals(3, pizzaOrdList.size());
		verify(pizzaorderRepository, times(1)).findAll();
	}
	
}
