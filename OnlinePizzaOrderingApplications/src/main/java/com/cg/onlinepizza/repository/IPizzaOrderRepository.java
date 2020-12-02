package com.cg.onlinepizza.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.model.PizzaOrder;

@Repository
public interface IPizzaOrderRepository extends JpaRepository<PizzaOrder, Integer>{

	@Query("select d from PizzaOrder d where d.orderDate like ?1")
	public List<PizzaOrder> viewOrdersListDate(LocalDate date);
	
//	@Query("select t from PizzaOrder t where t.calculateTotal like ?1")
//	Optional<PizzaOrder> calculateTotal(String size, Integer quantity);
}

