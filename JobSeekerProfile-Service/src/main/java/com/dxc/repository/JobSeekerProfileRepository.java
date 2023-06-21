package com.dxc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.dxc.model.JobSeekerProfile;


public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
	
	@Query("select p from JobSeekerProfile p where p.firstname=?1")
	JobSeekerProfile findByFirstname(String firstname);
	
	JobSeekerProfile findByEmail(String email);
	
	Optional<List<JobSeekerProfile>> findBySkill1(String skill1);
	Optional<List<JobSeekerProfile>> findBySkill2(String skill2);
	
}
