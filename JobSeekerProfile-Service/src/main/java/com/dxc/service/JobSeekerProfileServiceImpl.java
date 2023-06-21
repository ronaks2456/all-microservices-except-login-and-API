package com.dxc.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dxc.exception.ProfileNotExistsException;
import com.dxc.model.JobPostDto;
import com.dxc.model.JobSearchAndApplyDto;
import com.dxc.model.JobSeekerProfile;
import com.dxc.repository.JobSeekerProfileRepository;
@Service
public class JobSeekerProfileServiceImpl implements JobSeekerProfileService {

	@Autowired
	private JobSeekerProfileRepository repo;
	
	@Autowired
	public RestTemplate template;
	
	public JobSeekerProfile create(JobSeekerProfile jsp) {
		
		return repo.save(jsp);
	}

	@Override
	public List<JobSeekerProfile> getAllJobSeekerProfiles() {
		
		return repo.findAll();
	}

	@Override
	public JobSeekerProfile updateProfileByFirstname(JobSeekerProfile jsp, String firstname)
			throws ProfileNotExistsException {
		JobSeekerProfile jsp1 = repo.findByFirstname(firstname);
		jsp1.setAge(jsp.getAge());
		jsp1.setContactnumber(jsp.getContactnumber());
		jsp1.setEmail(jsp.getEmail());
		jsp1.setExperience(jsp.getExperience());
		jsp1.setFirstname(jsp.getFirstname());
		jsp1.setLastname(jsp.getLastname());
		jsp1.setLocation(jsp.getLocation());
		jsp1.setQualification(jsp.getQualification());
		jsp1.setSkill1(jsp.getSkill1());
		jsp1.setSkill2(jsp.getSkill2());
		repo.save(jsp1);
		return jsp1;
	}

	// This will get the user details and the list of the jobs he/she has applied
	
	
	@Override
	public JobSeekerProfile getUserandJobsApplied(String email) {
		// TODO Auto-generated method stub
		JobSeekerProfile jsp= repo.findByEmail(email);
		int cid=jsp.getCid();
		String url= "http://localhost:9992/job-search/applied-jobs/"+cid;
		JobSearchAndApplyDto[] jobseekerArray= template.getForObject(url, JobSearchAndApplyDto[].class);
		List<JobSearchAndApplyDto> jobseeker=Arrays.stream(jobseekerArray).toList();
		jobseeker.forEach(jobs -> {
			int jid=jobs.getJid(); 
			String url2="http://localhost:9991/job-post/get-job/"+jid; 
			JobPostDto jobPost=template.getForObject(url2, JobPostDto.class); 
			jobs.setJobPost(jobPost);
		});
		jsp.setJsa(jobseeker) ;
		repo.save(jsp);
		return jsp;
	}

	@Override
	public JobSeekerProfile getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	@Override
	public List<JobSeekerProfile> getBySkill(String skill) {
		// TODO Auto-generated method stub
		Optional<List<JobSeekerProfile>> jobSeeker=repo.findBySkill1(skill);
		Optional<List<JobSeekerProfile>> jobSeeker2=repo.findBySkill2(skill);
		List<JobSeekerProfile> listOne=jobSeeker.get();
		List<JobSeekerProfile> listTwo=jobSeeker2.get();
		List<JobSeekerProfile> newList = Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());;
		return newList;
		
	}

}
