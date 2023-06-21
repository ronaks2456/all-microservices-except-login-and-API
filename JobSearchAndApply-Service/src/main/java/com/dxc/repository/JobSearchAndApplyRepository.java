package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.JobSearchAndApply;


@Repository
public interface JobSearchAndApplyRepository extends JpaRepository<JobSearchAndApply, Long> {
	List<JobSearchAndApply> findByCid(int cid);
}
