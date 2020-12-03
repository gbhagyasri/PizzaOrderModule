package com.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import com.onlinepizza.model.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	String deleteCustomer(Integer customerId);

	Optional<Customer> viewCustomer(Integer customerid) ;

	List<Customer> viewCustomersList();

}
