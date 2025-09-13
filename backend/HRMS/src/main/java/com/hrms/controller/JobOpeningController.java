package com.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.JobOpening;
import com.hrms.repo.JobOpeningRepository;

@RestController
@RequestMapping("/api/job-opening")
public class JobOpeningController {

	@Autowired
	private JobOpeningRepository jobRepo;
	
	@PostMapping
	public JobOpening create(@RequestBody JobOpening j) {
		return jobRepo.save(j);
	}
	
	@PutMapping("/{jobPositionId}")
	public ResponseEntity<?> updateJob(@PathVariable Integer jobPositionId, @RequestBody JobOpening j){
		
		Optional<JobOpening> job = jobRepo.findById(jobPositionId);
		
		if (job.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
		
		JobOpening existingJob = job.get();

		existingJob.setJobPosition(j.getJobPosition());
		existingJob.setExperience(j.getExperience());
		existingJob.setSkills(j.getSkills());
		existingJob.setLocation(j.getLocation());
		
		jobRepo.save(existingJob);
		return ResponseEntity.ok(existingJob);
	}
	
	@DeleteMapping("/{jobPositionId}")
	public ResponseEntity<?> deleteJob(@PathVariable Integer jobPositionId){
		
		Optional<JobOpening> job = jobRepo.findById(jobPositionId);
		if(!job.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Job position id not found");
		}
		
		jobRepo.deleteById(jobPositionId);
		
		return ResponseEntity.ok("Job position deleted successfully");
	}
	
	@GetMapping("/{jobPositionId}")
	public ResponseEntity<?> searchJob(@PathVariable Integer jobPositionId) {
	    Optional<JobOpening> job = jobRepo.findById(jobPositionId);

	    if (!job.isPresent()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("Job position ID not found");
	    }

	    return ResponseEntity.ok(job.get());
	}
	
	@GetMapping("/get-all-job")
	public ResponseEntity<?> searchAllJob() {
	    List<JobOpening> jobs = jobRepo.findAll();

	    if (jobs.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT)
	                .body("No job openings available");
	    }

	    return ResponseEntity.ok(jobs);
	}
}
