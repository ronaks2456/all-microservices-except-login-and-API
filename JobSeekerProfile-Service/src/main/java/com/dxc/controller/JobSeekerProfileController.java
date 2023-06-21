package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.exception.ProfileNotExistsException;
import com.dxc.model.JobSeekerProfile;
import com.dxc.service.JobSeekerProfileService;

@RestController
@RequestMapping("/jobseekerprofile")
public class JobSeekerProfileController {
	
	@Autowired
	private JobSeekerProfileService service;
	
	
	// adding profile to the database
	
	@PostMapping("/addprofile")
	public JobSeekerProfile create(@RequestBody JobSeekerProfile jsp) {
		return service.create(jsp);	
     }
	
	//updating the profile by first searching the profile of the candidate using firstname and then updating it on the database
	
	
	@PutMapping("/updateprofile/{firstname}")
	public JobSeekerProfile updateProfileByFirstName(@PathVariable("firstname") String firstname,@RequestBody JobSeekerProfile jsp1) throws ProfileNotExistsException{
		JobSeekerProfile updatedprofile = service.updateProfileByFirstname(jsp1,firstname);
		return updatedprofile;
	}
	
	
	// Shows all the records of the profiles
	
	@GetMapping("/showallprofiles")
	public List<JobSeekerProfile>getAllProfiles(@RequestBody JobSeekerProfile jsp){
		return service.getAllJobSeekerProfiles();
	}
	
	
	//Shows the user profile 
	
	@GetMapping("/user/{email}")
	public JobSeekerProfile getUser(@PathVariable String email)
	{
		return service.getUser(email);
	}
	
	//Shows the user details and and all the jobs he/she has applied
	
	
	@GetMapping("/user/applied/{email}")
	public JobSeekerProfile getUserAndJobsApplied(@PathVariable String email)
	{
		return service.getUserandJobsApplied(email);
	}
	
	
	// Shows the candidates list with particular skills (this is to be 
	//								communicated to the shortlisting service for RECRUITER)
	@GetMapping("/recruiter/search-{skill}")
	public List<JobSeekerProfile> getBySkills(@PathVariable String skill)
	{
		return service.getBySkill(skill);
	}
}
