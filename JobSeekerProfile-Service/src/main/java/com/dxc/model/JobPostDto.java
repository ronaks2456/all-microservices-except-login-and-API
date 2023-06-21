package com.dxc.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class JobPostDto {
	
	private long jid;
	private String title;
	private String company;
	private String desc;
	private String tech1;
	private String tech2;
	public JobPostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobPostDto(long jid, String title, String company, String desc, String tech1, String tech2) {
		super();
		this.jid = jid;
		this.title = title;
		this.company = company;
		this.desc = desc;
		this.tech1 = tech1;
		this.tech2 = tech2;
	}
	public long getJid() {
		return jid;
	}
	public void setJid(long jid) {
		this.jid = jid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTech1() {
		return tech1;
	}
	public void setTech1(String tech1) {
		this.tech1 = tech1;
	}
	public String getTech2() {
		return tech2;
	}
	public void setTech2(String tech2) {
		this.tech2 = tech2;
	}
	@Override
	public String toString() {
		return "JobPost [jid=" + jid + ", title=" + title + ", company=" + company + ", desc=" + desc + ", tech1="
				+ tech1 + ", tech2=" + tech2 + "]";
	}
	
}
