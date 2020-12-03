package com.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.onlinepizza.model.Customer;
import com.onlinepizza.repository.ICustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepositry;

	/*
	 * Adding a Customer
	 */
	
	@Override
	public Customer addCustomer(Customer customer)// add the customer
	{
		return customerRepositry.save(customer);
	}
	
	/*
	 * Getting All Customers
	 */

	@Override
	public List<Customer> viewCustomersList()// view all customer
	{
		return customerRepositry.findAll();
	}

	/*
	 * Updating a Customer
	 */
	
	@Override
	public Customer updateCustomer(Customer customer)// update customer
	{
		return customerRepositry.save(customer);
	}

	/*
	 * Deleting Customer by using Id
	 */
	
	@Override
	public String deleteCustomer(Integer customerId) // delete the customer by using id
	{
		Optional<Customer> customer = customerRepositry.findById(customerId);
		if (customer.isEmpty()) {
			throw new CustomerIdNotFoundException(customerId + " is not available");
		} else {
			customerRepositry.deleteById(customerId);
			return "Deleted";
		}
	}

	/*
	 * Getting a Customer by Id
	 */
	
	@Override
	public Optional<Customer> viewCustomer(Integer customerId) // view customer by using id
	{
		Optional<Customer> customer = customerRepositry.findById(customerId);
		if (customer.isEmpty()) {
			throw new CustomerIdNotFoundException(customerId + " is not available");
		} else
			return customer;
	}

}
