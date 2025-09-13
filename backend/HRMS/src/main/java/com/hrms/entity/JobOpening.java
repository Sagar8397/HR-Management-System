package com.hrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_opening")
public class JobOpening {

	@Id
	@Column(name = "job_position_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobPositionId;

	@Column(name = "job_position")
	private String jobPosition;

	@Column(name = "location")
	private String location;

	@Column(name = "experiance")
	private String experience;
	
	@Column(name = "skills")
	private String skills;

	public Integer getJobPositionId() {
		return jobPositionId;
	}

	public void setJobPositionId(Integer jobPositionId) {
		this.jobPositionId = jobPositionId;
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
		return "JobOpening [jobPositionId=" + jobPositionId + ", jobPosition=" + jobPosition + ", location=" + location
				+ ", experience=" + experience + ", skills=" + skills + "]";
	}

	public JobOpening(Integer jobPositionId, String jobPosition, String location, String experience, String skills) {
		super();
		this.jobPositionId = jobPositionId;
		this.jobPosition = jobPosition;
		this.location = location;
		this.experience = experience;
		this.skills = skills;
	}

	public JobOpening() {
		super();
		// TODO Auto-generated constructor stub
	}
}
