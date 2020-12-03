package com.onlinepizza.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.model.Pizza;
import com.onlinepizza.service.PizzaServiceImpl;

@RestController
@Validated
@RequestMapping("/pizza")
public class PizzaController {
	@Autowired
	PizzaServiceImpl service;

	/*
	 * Adding a Pizza
	 */

	@PostMapping("/addPizza")
	public String addpizzas(@Valid @RequestBody Pizza pizza) {
		service.addPizza(pizza);
		return "added";
	}

	/*
	 * Getting All Pizzas
	 */

	@GetMapping("/allPizza")
	public List<Pizza> allPizza() {

		return service.viewPizzaAllList();

	}

	/*
	 * Removing a Pizza by using Id
	 */

	@DeleteMapping("/removePizza/{id}")
	public String remove(@PathVariable Integer id) {
		service.deletePizza(id);
		return "Moving to trash... Deleted";
	}

	/*
	 * Updating a Pizza
	 */

	@PutMapping("/updatePizza")
	public String update(@Valid @RequestBody Pizza pizza) {
		service.updatePizza(pizza);
		return "Updated";
	}

	/*
	 * Getting AllPizzas by Type
	 */

	@GetMapping("/allPizzadisplayByType/{pizzname}")
	public List<Pizza> allByType(@PathVariable String pizzname) {
		return service.viewPizza(pizzname);

	}

	/*
	 * Getting a Pizza by using Id
	 */

	@GetMapping("/findById/{id}")
	public Optional<Pizza> findById(@PathVariable Integer id) {
		return service.viewPizza(id);

	}

	/*
	 * Getting a Pizza by using Cost
	 */

	@GetMapping("/betweenCost/{c1}/{c2}")
	public List<Pizza> pizzaBTWcost(@PathVariable Integer c1, @PathVariable Integer c2) {
		return service.viewPizzaList(c1, c2);
	}

}
