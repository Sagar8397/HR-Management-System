package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.Salaries;
import com.hrms.repo.SalariesRepository;

@RestController
@RequestMapping("/api/salaries")
public class SalariesController {

	@Autowired
	private SalariesRepository salRepo;
	
	@PostMapping
	public Salaries create(@RequestBody Salaries s) {
		return salRepo.save(s);
	}
}
