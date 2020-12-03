package com.onlinepizza.service;

import com.onlinepizza.model.Admin;

public interface IAdminService {

		public Admin  addNewAdmin(Admin admin);
		public Admin signIn(Integer adminid, String password);
		public String  signOut(Admin admin);

		
		
	}