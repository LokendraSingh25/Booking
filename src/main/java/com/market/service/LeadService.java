package com.market.service;

import java.util.List;

import com.market.entity.Lead;



public interface LeadService {
	public void SaveReg(Lead lead);

	public List<Lead> findAllleads();

}
