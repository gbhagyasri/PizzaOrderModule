package com.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepizza.exceptions.InvalidMinCostMaxCostException;
import com.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.onlinepizza.model.Pizza;
import com.onlinepizza.repository.IPizzaRepository;

@Service
@Transactional
public class PizzaServiceImpl implements IPizzaService {
	@Autowired // injecting dependent objects
	private IPizzaRepository dao;

	/*
	 * Adding a Pizza
	 */

	public Pizza addPizza(Pizza pizza) {
		dao.save(pizza);
		return pizza;
	}

	/*
	 * Updating a Pizza
	 */

	public Pizza updatePizza(Pizza pizza) {

		return dao.save(pizza);
	}

	/*
	 * Removing a Pizza by using Id
	 */

	public Pizza deletePizza(int pizzaId) {
		Pizza piz = null;
		dao.deleteById(pizzaId);
		return piz;
	}

	/*
	 * Getting All Pizzas
	 */

	public List<Pizza> viewPizzaAllList() {

		List<Pizza> pizzaList = dao.findAll();
		dao.findAll();
		return pizzaList;
	}

	/*
	 * Getting AllPizzas by Type
	 */

	public List<Pizza> viewPizza(String pizzaType) {
		List<Pizza> pizzaList = dao.viewPizza(pizzaType);
		return pizzaList;
	}

	/*
	 * Getting a Pizza by using Id
	 */

	public Optional<Pizza> viewPizza(int pizzaId) {

		Optional<Pizza> pizz = dao.findById(pizzaId);
		if (pizz.isEmpty())
			throw new PizzaIdNotFoundException("     Enter a valid Pizza ID      ");
		else
			return pizz;
	}

	/*
	 * Getting a Pizza by using Cost
	 */

	public List<Pizza> viewPizzaList(double minCost, double maxCost) {

		List<Pizza> pizz = dao.viewPizzaList(minCost, maxCost);
		if (pizz.isEmpty())
			throw new InvalidMinCostMaxCostException(" Enter valid MinCost and MaxCost ");
		else
			return pizz;
	}

}
