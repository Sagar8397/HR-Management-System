package com.hrms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@Column(name = "sr_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srNo;

	@Column(name = "email")
	private String email;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "current_at")
	private LocalDateTime currentAt;

	@Column(name = "attendance")
	private String attendance;

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

	public LocalDateTime getCurrentAt() {
		return currentAt;
	}

	public void setCurrentAt(LocalDateTime currentAt) {
		this.currentAt = currentAt;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "Attendance [srNo=" + srNo + ", email=" + email + ", date=" + date + ", currentAt=" + currentAt
				+ ", attendance=" + attendance + "]";
	}

	public Attendance(Integer srNo, String email, LocalDate date, LocalDateTime currentAt, String attendance) {
		super();
		this.srNo = srNo;
		this.email = email;
		this.date = date;
		this.currentAt = currentAt;
		this.attendance = attendance;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
}
