package com.dxc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

public class JobSearchAndApplyDto {
	
	
	private long aid;
	private int jid;
	private int cid;	
	
	private JobPostDto jobPost;
	public JobSearchAndApplyDto() {
		super();
	}
	public JobSearchAndApplyDto(long aid, int jid, int cid, JobPostDto jobPost) {
		super();
		this.aid = aid;
		this.jid = jid;
		this.cid = cid;
		this.jobPost = jobPost;
	}
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public JobPostDto getJobPost() {
		return jobPost;
	}
	public void setJobPost(JobPostDto jobPost) {
		this.jobPost = jobPost;
	}
	@Override
	public String toString() {
		return "JobSearchAndApplyDto [aid=" + aid + ", jid=" + jid + ", cid=" + cid + ", jobPost=" + jobPost + "]";
	}
}