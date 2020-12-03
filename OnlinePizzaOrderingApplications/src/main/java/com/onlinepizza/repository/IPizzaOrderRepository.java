package com.onlinepizza.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinepizza.model.PizzaOrder;

@Repository
public interface IPizzaOrderRepository extends JpaRepository<PizzaOrder, Integer>{

	@Query("select d from PizzaOrder d where d.orderDate like ?1")
	public List<PizzaOrder> viewOrdersListDate(LocalDate date);
	
	public static String calculateTotal(String size, double quantity) {
		if(size.equals("SMALL")) {
			double val=quantity*250;
			String str=String.valueOf(val);
				return str;
			} 
			if(size.equals("MEDIUM")) {
				double val=quantity*450;
				String str=String.valueOf(val);
					return str;
			}
			if(size.equals("LARGE")) {
				double val=quantity*550;
				String str=String.valueOf(val);
					return str;
			}
			else
				return "InvalidSize";
	}
}

