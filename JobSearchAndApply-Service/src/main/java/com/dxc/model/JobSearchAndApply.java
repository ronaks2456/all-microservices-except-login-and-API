package com.dxc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="jobs_applied")
public class JobSearchAndApply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long aid;
	private int jid;
	private int cid;	
	public JobSearchAndApply() {
		super();
	}
	public JobSearchAndApply(long aid, int jid, int cid) {
		super();
		this.aid = aid;
		this.jid = jid;
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "JobSearchAndApply [aid=" + aid + ", jid=" + jid + ", cid=" + cid + "]";
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
}