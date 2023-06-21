package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.model.JobPostDto;
import com.dxc.model.JobSearchAndApply;
import com.dxc.service.JobSearchAndApplyService;

@RestController
@RequestMapping("/job-search")
public class JobSearchAndApplyController {
	
	@Autowired
	public JobSearchAndApplyService jss;
	
	
	
	@GetMapping("/{tech}")
	public List<JobPostDto> getDesiredJob(@PathVariable String tech)
	{
		return jss.searchJobs(tech);
	}
	
	@GetMapping("/applied-jobs/{cid}")
	public List<JobSearchAndApply> getAppliedJobs(@PathVariable int cid)
	{
		return jss.getJidByCid(cid);
	}
	
//	@PostMapping("/save-job")
//	public JobSearchAndApply saveJobs(@RequestBody JobSearchAndApply j)
//	{
//		return jss.saveJobApply(j);
//	}
	
	@PostMapping("/save-job/cid-{cid}_jid-{jid}")
	public JobSearchAndApply saveJobs(@PathVariable int jid, @PathVariable int cid)
	{
		return jss.saveJobApply(jid, cid);
	}
	
	

}
