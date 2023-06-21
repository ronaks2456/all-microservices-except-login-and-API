package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.JobSeekerProfile;
import com.dxc.service.ShortListingService;

@RestController
public class ShortlistingController {
	
	@Autowired
	private ShortListingService service;
	
	//Shortlisting candidates based on technical skills provided by them
	
	@GetMapping("/greet")
	public String getHello()
	{
		return "Hello";
	}
	
	@GetMapping("/candidates/skill-{tech}")
	public List<JobSeekerProfile> getCandidatesBySkills(@PathVariable String tech)
	{
		return service.getBySkills(tech);
	}
	
	@GetMapping("/candidate-{email}/contact")
	public String messageForCommunication(@PathVariable String email)
	{
		return service.messageForCommunication(email);
	}

}
