package com.market.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.dto.LeadDto;
import com.market.entity.Lead;
import com.market.service.LeadService;


@Controller

public class Leadcontroller {

	@Autowired
	private LeadService leadService;


	// localhost:8080/create
	@RequestMapping("/create")
	public String viewcreateLeadform() {
		return "create_lead";
	}

	@RequestMapping("/SaveReg")
	public String saveOnelead(LeadDto dto, Model model) {
		Lead lead = new Lead();
		lead.setFirstname(dto.getFirstname());
		lead.setLastname(dto.getLastname());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		model.addAttribute("msg", "Lead saved");
		leadService.SaveReg(lead);

		return "create_lead";
	}

	/*
	 * @RequestMapping("/SaveReg") public String saveOnelead(@ModelAttribute Lead
	 * lead, Model model) { model.addAttribute("msg", "Lead saved");
	 * leadService.SaveReg(lead); return "create_lead";
	 *

	}*/

	// localhost:8080/list
	@RequestMapping("/list")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.findAllleads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
		return "list_lead";

	}
}
