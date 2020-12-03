package com.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import com.onlinepizza.model.Pizza;

public interface IPizzaService {

	Pizza addPizza(Pizza pizza);

	Pizza updatePizza(Pizza pizza);

	Pizza deletePizza(int pizza);

	List<Pizza> viewPizzaAllList();

	Optional<Pizza>  viewPizza(int pizzaId) ;

	List<Pizza> viewPizzaList(double minCost, double maxCost);

	List<Pizza> viewPizza(String pizzaType);

}
