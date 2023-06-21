package com.dxc.service;

import java.util.List;

import com.dxc.model.JobSearchAndApply;
import com.dxc.model.JobPostDto;

public interface JobSearchAndApplyService {
	
	// search
	List<JobPostDto> searchJobs(String tech);
	
	// save the apply job
	JobSearchAndApply saveJobApply(int jid, int cid);
	
	
	//getting applied Job IDs from the Candidate's ID
	List<JobSearchAndApply> getJidByCid(int cid);
	
	

}
