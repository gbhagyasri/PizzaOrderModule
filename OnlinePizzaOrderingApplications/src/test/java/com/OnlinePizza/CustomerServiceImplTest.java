package com.OnlinePizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onlinepizza.model.Customer;
import com.onlinepizza.repository.ICustomerRepository;
import com.onlinepizza.service.CustomerServiceImpl;
@TestInstance(Lifecycle.PER_CLASS)
class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl service;
	@Mock
	ICustomerRepository customerRepositry;
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
     void saveCustomerTest()//test the save customer method
	{
		Customer cus = new Customer("ragavan", "978589654","ragav@gmail.com","tirupur","ragav","ragav123");
		when(customerRepositry.save(cus)).thenReturn(cus);
		assertEquals(cus,service.addCustomer(cus));
	}
	@Test
	void viewCustomerTest() {   //test the view customer method
		ArrayList<Customer> list=new ArrayList<>();
		Customer cus1 = new Customer("ragavan"," 978589654","ragavan@gmail.com","tirupur","ragavan","ragavan123");
		Customer cus2 = new Customer("ragav","978589654","ragav@gmail.com","tirupur","ragav","ragav123");
		Customer cus3 = new Customer("sri", "978589654","sri@gmail.com","tirupur","sri","sri123");
		list.add(cus1);
		list.add(cus2);
		list.add(cus3);
		when(customerRepositry.findAll()).thenReturn(list);
		assertEquals(3, service.viewCustomersList().size());
		
	}
	@Test
	void updateCustomerTest() { //test the update customer method
		Customer cus1 = new Customer("ragavan"," 978589654","ragavan@gmail.com","tirupur","ragavan","ragavan123");
		cus1.setCustomerName("sri");
		when(customerRepositry.save(cus1)).thenReturn(cus1);
		assertEquals("sri",service.updateCustomer(cus1).getCustomerName());
	}
	@Test
	void viewByIdTest() {  //view the customer using id
		Optional<Customer> cus1 = Optional.of(new Customer("ragavan", "9785896546","ragavan@gmail.com","tirupur","ragavan","ragavan123"));
		when(customerRepositry.findById(1)).thenReturn(cus1);
		assertEquals(true,service.viewCustomer(1).isPresent());
	}
}
