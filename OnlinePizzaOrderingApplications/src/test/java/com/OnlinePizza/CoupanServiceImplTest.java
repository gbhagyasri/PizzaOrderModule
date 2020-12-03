package com.OnlinePizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.onlinepizza.model.Coupan;
import com.onlinepizza.repository.ICoupanRepository;
import com.onlinepizza.service.CoupanServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class CoupanServiceImplTest {

	@InjectMocks
	CoupanServiceImpl service;
	@Mock
	ICoupanRepository dao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	 void testAddCoupan() {
		Coupan cou = new Coupan("Get40%", "40%Discount", "Min_Order_999");
		when(dao.save(cou)).thenReturn(cou);
		cou = service.addCoupan(cou);
		assertEquals("40%Discount", cou.getCoupanType());
		verify(dao, times(1)).save(cou);
	}

	@Test
	 void testEditCoupan() {
		Coupan cou = new Coupan("Get40%", "40%Discount", "Min_Order_999");
		when(dao.save(cou)).thenReturn(cou);
		// service.addCoupan(cou);
		cou.setCoupanType("40%Off");
		cou = service.editCoupan(cou);
		assertEquals("40%Off", cou.getCoupanType());
	}

	@Test
	 void testGetCoupanById() {
		Optional<Coupan> cou = Optional.of(new Coupan("Get40%", "40%Discount", "Min_Order_999"));
		when(dao.findById(1)).thenReturn(cou);
		Optional<Coupan> coupan = service.getCoupanById(1);
		Coupan object = coupan.get();
		assertEquals("40%Discount", object.getCoupanType());
	}

	@Test
	 void testViewCoupan() {
		List<Coupan> list = new ArrayList<Coupan>();
		Coupan c1 = new Coupan("Get40%", "40%Discount", "Min_Order_999");
		Coupan c2 = new Coupan("GetCola", "Get_a_free_cola", "400ml_cola_on_largePizza");
		Coupan c3 = new Coupan("Buy2Get35%", "35%Disount", "Buy_any_two_pizzas");
		Coupan c4 = new Coupan("GetFrenchFries", "Medium_french_fries", "Get_medium_french_fries_on_orders_above_799");
		Coupan c5 = new Coupan("GetCombo", "French_fries_and_cola_free",
				"Applicable_only_on_weekends_and_orders_above999");
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		when(dao.findAll()).thenReturn(list);
		List<Coupan> coupanList = service.viewCoupans();
		assertEquals(5, coupanList.size());
		verify(dao, times(1)).findAll();
	}
}
