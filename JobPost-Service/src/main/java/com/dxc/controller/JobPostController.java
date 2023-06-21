package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.JobPost;
import com.dxc.service.JobPostService;

@RestController
@RequestMapping("/job-post")
public class JobPostController {
	
	@Autowired
	JobPostService jps;
	
	@PostMapping("/save-job")
	public JobPost saveJob(@RequestBody JobPost jobPost)
	{
		return jps.saveJob(jobPost);
	}
	
	@GetMapping("/all-jobs")
	public List<JobPost> getAllJobs()
	{
		return jps.getAllJobs();
	}
	
	@PutMapping("/update-job/{jid}")
	public JobPost updateJob(@RequestBody JobPost jobPost, @PathVariable Long jid)
	{
		return jps.updateJob(jobPost, jid);
	}
	@DeleteMapping("/delete-job/{jid}")
	public String deleteJob(@PathVariable Long jid)
	{
		jps.deleteJobPostById(jid);
		return "Job with JobPostID "+jid+" has been deleted";
	}
	@GetMapping("/job-tech/{tech}")
	public List<JobPost> getJobsByTech(@PathVariable String tech)
	{
		return jps.getByTech(tech);
	}
	@GetMapping("/get-job/{jid}")
	public JobPost getById(@PathVariable Long jid)
	{
		return jps.findById(jid);
	}

}
