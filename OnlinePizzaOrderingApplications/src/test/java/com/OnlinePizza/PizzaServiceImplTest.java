package com.OnlinePizza;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onlinepizza.model.Pizza;
import com.onlinepizza.repository.IPizzaRepository;
import com.onlinepizza.service.PizzaServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class PizzaServiceImplTest {
	@InjectMocks
	PizzaServiceImpl service;
	@Mock
	IPizzaRepository dao;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void viewAllPizzatest() {
		List<Pizza> list = new ArrayList<Pizza>();
		Pizza p1 = new Pizza("MEDIUM", "DOUBLECHEESE", "VEG", 500.0, 250.0);
		Pizza p2 = new Pizza("MEDIUM", "CHEESE", "VEG", 600.0, 350.0);
		Pizza p3 = new Pizza("REGULAR", "ClassicCHEESE", "VEG", 500.0, 150.0);
		Pizza p4 = new Pizza("MEDIUM", "DOUBLECHEESE", "NONVEG", 800.0, 350.0);
		Pizza p5 = new Pizza("MEDIUM", "DOUBLECHEESE", "VEG", 900.0, 450.0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		when(dao.findAll()).thenReturn(list);
		List<Pizza> pizzlist = service.viewPizzaAllList();
		assertEquals(5, pizzlist.size());
		verify(dao, times(2)).findAll();
	}

	@Test
	void addPizzaTest() {
		Pizza p1 = new Pizza("MEDIUM", "DOUBLECHEESE", "VEG", 500.0, 250.0);
		when(dao.save(p1)).thenReturn(p1);
		Pizza addchk = service.addPizza(p1);
		assertEquals("MEDIUM", addchk.getPizzaType());
		assertEquals("DOUBLECHEESE", addchk.getPizzaName());
	}

	@Test
	void updatePizzaTest() {
		Pizza p1 = new Pizza("MEDIUM", "DOUBLECHEESE", "VEG", 500.0, 250.0);
		when(dao.save(p1)).thenReturn(p1);
		Pizza upd = service.updatePizza(p1);
		assertEquals("MEDIUM", upd.getPizzaType());
		assertEquals("DOUBLECHEESE", upd.getPizzaName());
	}

	@Test
	void PizzaByTypeTest() {
		List<Pizza> list = new ArrayList<Pizza>();
		List<Pizza> pizz = new ArrayList<Pizza>();
		Pizza p1 = new Pizza("MEDIUM", "DOUBLECHEESE", "VEG", 500.0, 250.0);
		Pizza p2 = new Pizza("REGULAR", "CHEESE", "VEG", 600.0, 350.0);
		Pizza p3 = new Pizza("SMALL", "ClassicCHEESE", "VEG", 500.0, 150.0);
		Pizza p4 = new Pizza("HUGECRUST", "DOUBLECHEESE", "NONVEG", 800.0, 350.0);
		Pizza p5 = new Pizza("BIG", "DOUBLECHEESE", "VEG", 900.0, 450.0);
		Pizza p6 = new Pizza("REGULAR", "ClassicCHEESE", "VEG", 500.0, 150.0);
		Pizza p7 = new Pizza("REGULAR", "DOUBLECHEESE", "NONVEG", 800.0, 350.0);
		Pizza p8 = new Pizza("SMALL", "DOUBLECHEESE", "VEG", 900.0, 450.0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		pizz.add(p6);
		pizz.add(p7);
		pizz.add(p8);
		when(dao.viewPizza("REGULAR")).thenReturn(pizz);
		List<Pizza> pizzlist = service.viewPizza("REGULAR");

		assertEquals(3, pizzlist.size());
	}

	@Test
	void findPizzaTest() {
		Optional<Pizza> p1 = Optional.of(new Pizza("MEDIUM", "DOUBLECHEESE", "VEG", 500.0, 250.0));
		when(dao.findById(1)).thenReturn(p1);
		Optional<Pizza> pizz = service.viewPizza(1);
		Pizza obj = pizz.get();
		assertEquals("MEDIUM", obj.getPizzaType());
	}
}
