package com.dxc.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.JobPost;
import com.dxc.repository.JobPostRepository;



@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	JobPostRepository jpr;
	
	@Override
	public JobPost saveJob(JobPost jobPost) {
		// TODO Auto-generated method stub
		return jpr.save(jobPost);
	}

	@Override
	public JobPost updateJob(JobPost jobPost, Long jid) {
		// TODO Auto-generated method stub
		JobPost depDB = jpr.findById(jid).get();

    if (Objects.nonNull(jobPost.getTitle()) && !"".equalsIgnoreCase(jobPost.getTitle())) 
    {
        depDB.setTitle(jobPost.getTitle());
    }
    if (Objects.nonNull(jobPost.getCompany()) && !"".equalsIgnoreCase(jobPost.getCompany())) 
    {
        depDB.setCompany(jobPost.getCompany());
    }
    if (Objects.nonNull(jobPost.getDesc()) && !"".equalsIgnoreCase(jobPost.getDesc())) 
    {
        depDB.setDesc(jobPost.getDesc());
    }
    if (Objects.nonNull(jobPost.getTech1()) && !"".equalsIgnoreCase(jobPost.getTech1())) 
    {
        depDB.setTech1(jobPost.getTech1());
    }
    if (Objects.nonNull(jobPost.getTech2()) && !"".equalsIgnoreCase(jobPost.getTech2())) 
    {
        depDB.setTech2(jobPost.getTech2());
    }
    return jpr.save(depDB);
}

	@Override
	public void deleteJobPostById(Long jid) {
		// TODO Auto-generated method stub
		jpr.deleteById(jid);
	}

	@Override
	public List<JobPost> getAllJobs() {
		// TODO Auto-generated method stub
		return jpr.findAll();
	}

	@Override
	public List<JobPost> getByTech(String tech) {
		// TODO Auto-generated method stub
		Optional<List<JobPost>> jobPosts=jpr.findByTech1(tech);
		Optional<List<JobPost>> jobPosts2=jpr.findByTech2(tech);
		List<JobPost> listOne=jobPosts.get();
		List<JobPost> listTwo=jobPosts2.get();
		List<JobPost> newList = Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());;
		return newList;
	}

	@Override
	public JobPost findById(Long jid) {
		// TODO Auto-generated method stub
		return jpr.findById(jid).get();
	}

}
