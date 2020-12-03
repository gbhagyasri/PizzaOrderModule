package com.onlinepizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepizza.model.Admin;
import com.onlinepizza.repository.IAdminRepository;

@Service("name=adminservice")
@Transactional
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private IAdminRepository adminRepository;
	/*
	 * login
	 */
	public Admin signIn(Integer id, String password) {
		Admin signedAdmin = adminRepository.signIn(id, password);
		if (signedAdmin != null) {
			return signedAdmin;
		} else {
			return new Admin();
		}
	}
	/*
	 * adding user
	 */
	public Admin addNewAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}
	
			/*
	 * logout
	 */
	public String signOut(Admin admin) {

		return "SignedOut Successfully";

	}
		
	}
			

