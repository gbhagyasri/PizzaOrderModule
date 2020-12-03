package com.onlinepizza.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinepizza.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
