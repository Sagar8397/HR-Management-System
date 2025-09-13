package com.hrms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.Attendance;
import com.hrms.repo.AttendanceRepository;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceRepository attendRepo;
	
	@PostMapping
	public Attendance create(@RequestBody Attendance a) {
		a.setCurrentAt(LocalDateTime.now());
		return attendRepo.save(a);
	}
	
	@GetMapping
	public List<Attendance> list(){
		return attendRepo.findAll();
	}
	
	@GetMapping("/{email}")
	public List<Attendance> getByEmail(@PathVariable String email) {
	    return attendRepo.findByEmail(email);
	}
}
