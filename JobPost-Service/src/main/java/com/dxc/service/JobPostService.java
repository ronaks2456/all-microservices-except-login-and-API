package com.dxc.service;

import java.util.List;

import com.dxc.model.JobPost;

public interface JobPostService {
	JobPost saveJob(JobPost jobPost);
	JobPost updateJob(JobPost jobPost, Long jid);
	JobPost findById(Long jid);
	void deleteJobPostById(Long jid);
	List<JobPost> getAllJobs();
	List<JobPost> getByTech(String tech);
}

