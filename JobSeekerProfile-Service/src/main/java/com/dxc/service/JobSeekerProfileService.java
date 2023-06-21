package com.dxc.service;

import java.util.List;

import com.dxc.exception.ProfileNotExistsException;
import com.dxc.model.JobSeekerProfile;

public interface JobSeekerProfileService {
	
	public JobSeekerProfile create(JobSeekerProfile jsp);
	
	public  JobSeekerProfile updateProfileByFirstname(JobSeekerProfile jsp, String firstname)throws ProfileNotExistsException;
	
	public List<JobSeekerProfile> getAllJobSeekerProfiles();
	
	public JobSeekerProfile getUserandJobsApplied(String email);
	
	public JobSeekerProfile getUser(String email);
	
	public List<JobSeekerProfile> getBySkill(String skill);
	
}
