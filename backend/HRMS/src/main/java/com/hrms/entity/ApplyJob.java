package com.hrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apply_job")
public class ApplyJob {

	@Id
	@Column(name = "apply_job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer applyJobId;

	@Column(name = "email")
	private String email;

	@Column(name = "job_position_id")
	private Integer jobPositionId;

	@Column(name = "job_position")
	private String jobPosition;

	@Column(name = "location")
	private String location;

	@Column(name = "experience")
	private String experience;

	public Integer getJobPositionId() {
		return jobPositionId;
	}

	public void setJobPositionId(Integer jobPositionId) {
		this.jobPositionId = jobPositionId;
	}

	@Column(name = "skills")
	private String skills;

	public Integer getApplyJobId() {
		return applyJobId;
	}

	public void setApplyJobId(Integer applyJobId) {
		this.applyJobId = applyJobId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "ApplyJob [applyJobId=" + applyJobId + ", email=" + email + ", jobPositionId=" + jobPositionId
				+ ", jobPosition=" + jobPosition + ", location=" + location + ", experience=" + experience + ", skills="
				+ skills + "]";
	}

	public ApplyJob(Integer applyJobId, String email, Integer jobPositionId, String jobPosition, String location,
			String experience, String skills) {
		super();
		this.applyJobId = applyJobId;
		this.email = email;
		this.jobPositionId = jobPositionId;
		this.jobPosition = jobPosition;
		this.location = location;
		this.experience = experience;
		this.skills = skills;
	}

	public ApplyJob() {
		super();
		// TODO Auto-generated constructor stub
	}
}
