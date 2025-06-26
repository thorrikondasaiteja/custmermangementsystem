package com.vcube.SpringBootJpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer1")
//@Getter
//@Setter
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This is key!


	private int cid;
	private String cname;
	private long cphoneno;
	private int csal;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getCphoneno() {
		return cphoneno;
	}
	public void setCphoneno(long cphoneno) {
		this.cphoneno = cphoneno;
	}
	public int getCsal() {
		return csal;
	}
	public void setCsal(int csal) {
		this.csal = csal;
	}
	
//
	
}
