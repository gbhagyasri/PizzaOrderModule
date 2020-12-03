package com.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import com.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.onlinepizza.model.Coupan;



public interface ICoupanService {

	Coupan addCoupan(Coupan coupan);
 
	Coupan editCoupan(Coupan coupan);

	void deleteCoupan(Integer coupanId);
	
    List<Coupan> viewCoupans();
    
    Optional<Coupan> getCoupanById(Integer coupanId);
   
}