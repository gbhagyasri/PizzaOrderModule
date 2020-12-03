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

import com.onlinepizza.model.Admin;
import com.onlinepizza.repository.IAdminRepository;
import com.onlinepizza.service.AdminServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)

class AdminServiceTest {
	@InjectMocks
	AdminServiceImpl service;
	@Mock
	IAdminRepository dao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void signIn() 
	{
		Admin admin= new Admin(null, "Harshika","Pilla");
		when(dao.signIn(1,"Pilla")).thenReturn(admin);
		Admin adchk= service.signIn(1,"Pilla");
		assertEquals("Harshika",adchk.getAdminType());
	}
	@Test
	void addNewAdmin()
	{
		Admin admin= new Admin(null, "adminType","password");
		when(dao.save(admin)).thenReturn(admin);
		Admin chck= service.addNewAdmin(admin);
		assertEquals("adminType",chck.getAdminType());
		assertNotEquals("Password",chck.getPassword());
	}
	@Test
	void signOut() 
	{
		Admin admin= new Admin(null, "admin","pasd");
		when(dao.save(admin)).thenReturn(admin);
		assertEquals("admin",dao.save(admin).getAdminType());
	}
	

}

