package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.Repository.LeadRepository;
import com.market.entity.Lead;


@Service
public class LeadServiceIMPL implements LeadService  {
	
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void SaveReg(Lead lead) {
		leadRepo.save(lead);
		

	}

	@Override
	public List<Lead> findAllleads() {
       List<Lead> leads = leadRepo.findAll();
       return leads;
		
	}

	

}
