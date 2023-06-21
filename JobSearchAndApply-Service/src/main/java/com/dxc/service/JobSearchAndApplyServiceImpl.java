package com.dxc.service;

import java.util.List;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dxc.model.JobSearchAndApply;
import com.dxc.model.JobPostDto;
import com.dxc.repository.JobSearchAndApplyRepository;
@Service
public class JobSearchAndApplyServiceImpl implements JobSearchAndApplyService {

	@Autowired
	private RestTemplate template; 
	
	@Autowired
	private JobSearchAndApplyRepository repo;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<JobPostDto> searchJobs(String tech) {
		String url="http://localhost:9991/job-post/job-tech/"+tech;
		return template.getForObject(url, List.class) ;
	}

	@Override
	public JobSearchAndApply saveJobApply(int jid, int cid) {
		// TODO Auto-generated method stub
		JobSearchAndApply j=new JobSearchAndApply();
		j.setJid(jid);
		j.setCid(cid);
		return repo.save(j);
	}

	@Override
	public List<JobSearchAndApply> getJidByCid(int cid) {
		return repo.findByCid(cid);
	}

}
