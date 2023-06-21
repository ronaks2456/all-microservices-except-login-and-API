package com.dxc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.dxc.model.JobPost;


@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {
	Optional<List<JobPost>> findByTech1(String tech1);
	Optional<List<JobPost>> findByTech2(String tech2);
}
