package com.hrms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leaves")
public class Leave {

	@Id
	@Column(name = "sr_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srNo;

	@Column(name = "email")
	private String email;

	@Column(name = "leave_date")
	private LocalDate date;

	@Column(name = "response")
	private String response;

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Leave [srNo=" + srNo + ", email=" + email + ", date=" + date + ", response=" + response + "]";
	}

	public Leave(Integer srNo, String email, LocalDate date, String response) {
		super();
		this.srNo = srNo;
		this.email = email;
		this.date = date;
		this.response = response;
	}

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
}
