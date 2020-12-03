package com.onlinepizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlinepizza.model.Pizza;

public interface IPizzaRepository extends JpaRepository<Pizza, Integer>{
    @Query("select p from Pizza p where p.pizzaType=?1")
	List<Pizza> viewPizza(String pizzaType);	
    @Query("select p from Pizza p where p.pizzaCost between ?1 and ?2")
    List<Pizza> viewPizzaList(double minCost, double maxCost);
}
