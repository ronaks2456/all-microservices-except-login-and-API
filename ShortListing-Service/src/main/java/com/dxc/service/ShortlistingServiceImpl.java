package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dxc.model.JobSeekerProfile;

@Service
public class ShortlistingServiceImpl implements ShortListingService {

	@Autowired
	private RestTemplate template;
	
	@Override
	public List<JobSeekerProfile> getBySkills(String tech) {
		// TODO Auto-generated method stub
		String url="http://localhost:8081/jobseekerprofile/recruiter/search-"+tech;
		return template.getForObject(url, List.class) ;
	}

	@Override
	public String messageForCommunication(String email) {
		// TODO Auto-generated method stub
		String url2="http://localhost:8081/jobseekerprofile/user/"+email;
		JobSeekerProfile jbp=template.getForObject(url2, JobSeekerProfile.class);
		String msg= "Below are the communication details of your selected candidate: \nThe email address is:"+
						jbp.getEmail()+"\nThe phone number of your candidate is: "+jbp.getContactnumber();
		
		return msg;
	}

}
