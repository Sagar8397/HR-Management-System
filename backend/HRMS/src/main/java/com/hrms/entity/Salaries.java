package com.hrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salaries")
public class Salaries {

	@Id
	@Column(name = "sr_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srNo;

	@Column(name = "email")
	private String email;
	
	@Column(name = "salary")
	private double salary;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salaries [srNo=" + srNo + ", email=" + email + ", salary=" + salary + "]";
	}

	public Salaries(Integer srNo, String email, double salary) {
		super();
		this.srNo = srNo;
		this.email = email;
		this.salary = salary;
	}

	public Salaries() {
		super();
		// TODO Auto-generated constructor stub
	}
}
