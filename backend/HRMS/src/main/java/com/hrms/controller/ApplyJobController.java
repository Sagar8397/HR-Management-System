package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.ApplyJob;
import com.hrms.repo.ApplyJobRepository;

@RestController
@RequestMapping("/api/apply-job")
public class ApplyJobController {

	@Autowired
	private ApplyJobRepository applyJobRepo;

	@PostMapping
	public ApplyJob create(@RequestBody ApplyJob a) {
		return applyJobRepo.save(a);
	}

	@GetMapping
	public List<ApplyJob> getAll() {
		return applyJobRepo.findAll();
	}

	// UPDATE
	@PutMapping("/{id}")
	public ApplyJob update(@PathVariable Integer id, @RequestBody ApplyJob updatedJob) {
		return applyJobRepo.findById(id).map(existingJob -> {
			existingJob.setEmail(updatedJob.getEmail());
			existingJob.setJobPositionId(updatedJob.getJobPositionId());
			existingJob.setJobPosition(updatedJob.getJobPosition());
			existingJob.setLocation(updatedJob.getLocation());
			existingJob.setExperience(updatedJob.getExperience());
			existingJob.setSkills(updatedJob.getSkills());
			return applyJobRepo.save(existingJob);
		}).orElseThrow(() -> new RuntimeException("ApplyJob not found with id " + id));
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return applyJobRepo.findById(id).map(job -> {
			applyJobRepo.delete(job);
			return "ApplyJob with id " + id + " deleted successfully!";
		}).orElseThrow(() -> new RuntimeException("ApplyJob not found with id " + id));
	}
}
