package com.dxc.service;

import java.util.List;

import com.dxc.model.JobSeekerProfile;

public interface ShortListingService {
	List<JobSeekerProfile> getBySkills(String tech);
	String messageForCommunication(String email);
	
}
