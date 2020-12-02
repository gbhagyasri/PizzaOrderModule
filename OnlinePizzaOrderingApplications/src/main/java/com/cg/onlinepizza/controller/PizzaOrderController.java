package com.cg.onlinepizza.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.model.PizzaOrder;
import com.cg.onlinepizza.service.IPizzaOrderService;

	@RestController
	@Validated
	@RequestMapping("/pizzaorders")
	public class PizzaOrderController {
		
			@Autowired
			IPizzaOrderService service;
			
			@PostMapping("/bookpizzaorders")  //http://localhost:1220/pizzaorders/bookpizzaorders
			public ResponseEntity<Boolean> bookpizzaorder(@Valid @RequestBody PizzaOrder order){
				@SuppressWarnings("unused")
				PizzaOrder entity =service.bookPizzaOrder(order);
				ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(true, HttpStatus.OK);
				return responseEntity;	
			}
			
			@PutMapping("/update")
			public ResponseEntity<Boolean> updatePizzaOrder(@Valid @RequestBody PizzaOrder order){
			   service.updatePizzaOrder(order);
				ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(true, HttpStatus.OK);
				return responseEntity;
			}
			
			@DeleteMapping("/delete")
			public String cancelPizzaOrder(@RequestParam Integer id)  {
				service.cancelPizzaOrder(id);
				return "Deleted PizzaOrder";
			}
			
			@GetMapping("/find/{bookingOrderId}")
			public Optional<PizzaOrder> viewPizzaOrder(@PathVariable("bookingOrderId") Integer bookingOrderId){
				Optional<PizzaOrder> entity =service.viewPizzaOrder(bookingOrderId);
				return entity;
			}
			
			@GetMapping("/all")   //http://localhost:1220/pizzaorders/all
			public ResponseEntity<List<PizzaOrder>> viewOrdersList(){
				List<PizzaOrder> list = service.viewOrdersList();
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
			
			@GetMapping("/viewByDate/{date}")
			public ResponseEntity<List<PizzaOrder>> viewOrdersList(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
				List<PizzaOrder> list = service.viewOrdersListDate(date);
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
//			
//			@GetMapping("/calculatebill/total")
//			public Optional<PizzaOrder> calculateTotal(@PathVariable("total") String size, Integer quantity ) {
//				Optional<PizzaOrder> list = service.calculateTotal(size, quantity);
//				return list;
//			}
	}
