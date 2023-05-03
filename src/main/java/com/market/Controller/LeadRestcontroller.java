package com.market.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.Repository.LeadRepository;
import com.market.dto.LeadDto;
import com.market.entity.Lead;

@RestController
@RequestMapping("/api/leads")
public class LeadRestcontroller {
	
	@Autowired
	private LeadRepository leadRepository;
	//http://localhost:8080/api/leads
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead>leads=leadRepository.findAll();
		return leads;
		
		
		
		
		
	}
	
	@PostMapping
	public void Savelead(@RequestBody Lead lead) {
		
		leadRepository.save(lead);
		
	}
	//http://localhost:8080/api/leads/{id}
	@DeleteMapping("/{id}")
	public void deleteoneLeadById(
			@PathVariable("id")long id) {
		
		leadRepository.deleteById(id);
	}
		

	//http://localhost:8080/api/leads
	@PutMapping
	public void updateoneLead(@RequestBody LeadDto leadDto) {
	Lead l = new Lead();	
	l.setId(leadDto.getId());
	l.setFirstname(leadDto.getFirstname());
	l.setLastname(leadDto.getLastname());
	l.setEmail(leadDto.getEmail());
	l.setMobile(leadDto.getMobile());
     leadRepository.save(l);
		
	}

	//http://localhost:8080/api/leads/
	@GetMapping("/{id}")
	public Lead getLeadById(@PathVariable("id")long id){
Optional<Lead> FindById = leadRepository.findById(id);
return FindById.get();
		
		
		
	}
			
		
	}


