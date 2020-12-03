package com.onlinepizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlinepizza.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("select u from Admin u where admin_id=?1 and password=?2")
	public Admin signIn(Integer integer,String string);

}
