package com.OnlinePizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinepizza.model.User;
import com.onlinepizza.repository.IUserRepository;
import com.onlinepizza.service.UserServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)

class UserServiceTest {
	@InjectMocks
	UserServiceImpl service;
	@Mock
	IUserRepository dao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void signIn() 
	{
		User user= new User("Harshika","Pilla");
		when(dao.signIn(1,"Pilla")).thenReturn(user);
		User usrchk= service.signIn(1,"Pilla");
		assertEquals("Harshika",usrchk.getUserName());
	}
	@Test
	void addNewUser()
	{
		User user= new User("userName","password");
		when(dao.save(user)).thenReturn(user);
		User chck= service.addNewUser(user);
		assertEquals("userName",chck.getUserName());
		assertNotEquals("Password",chck.getPassword());
	}
	@Test
	void signOut() 
	{
		User user= new User("user","pasd");
		when(dao.save(user)).thenReturn(user);
		assertEquals("user",dao.save(user).getUserName());
	}
	

}
	