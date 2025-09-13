package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.Leave;
import com.hrms.repo.LeaveRepository;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

	@Autowired
	private LeaveRepository leaveRepo;

	@PostMapping
	public Leave create(@RequestBody Leave l) {
		return leaveRepo.save(l);
	}

	@GetMapping
	public List<Leave> list() {
		return leaveRepo.findAll();
	}

	@PutMapping("/{srNo}")
	public ResponseEntity<Leave> update(@PathVariable int srNo, @RequestBody Leave l) {
		return leaveRepo.findBySrNoAndEmail(srNo, l.getEmail())
	    		.map(lea -> {
	        lea.setResponse(l.getResponse());
	        Leave updated = leaveRepo.save(lea);
	        return ResponseEntity.ok(updated);
	    }).orElse(ResponseEntity.notFound().build());
	}

	
}
