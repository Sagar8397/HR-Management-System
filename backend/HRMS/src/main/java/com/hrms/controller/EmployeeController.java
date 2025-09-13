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

import com.hrms.entity.Employee;
import com.hrms.repo.EmployeeRepository;
import com.hrms.repo.EmployeeRepository1;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private EmployeeRepository1 empRepo1;

	@PostMapping
	public Employee create(@RequestBody Employee e) {
		return empRepo.save(e);
	}

	@GetMapping("/{email}")
	public List<Employee> auth(@PathVariable String email) {
		return empRepo.findByEmail(email);
	}

	@PostMapping("/auth")
	public ResponseEntity<?> auth1(@RequestBody Employee e) {
		String email = e.getEmail();
		String password = e.getPassword();

		Optional<Employee> employees = empRepo.findByEmailAndPassword(email, password);

		if (employees.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
//	    return ResponseEntity.ok(employees.get()); // return first match
		return ResponseEntity.ok("valid");
	}

	@GetMapping
	public List<Employee> list() {
		return empRepo.findAll();
	}

	// ✅ Update employee by email
	@PutMapping("/update-salary")
	public ResponseEntity<?> updateSalary(@RequestBody Employee request) {
		String email = request.getEmail();
		Double newSalary = request.getSalary();

		Employee emp = empRepo1.findByEmail(email);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with email: " + email);
		}

		emp.setSalary(newSalary);
		empRepo.save(emp);

		return ResponseEntity.ok(emp);
	}

	@PutMapping("/t-leaves")
	public ResponseEntity<?> updateLeaves(@RequestBody Employee request) {
		String email = request.getEmail();
		String leaves = request.getLeaves();

		Employee emp = empRepo1.findByEmail(email);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with email: " + email);
		}

		emp.setLeaves(leaves);
		empRepo.save(emp);

		return ResponseEntity.ok(emp);
	}

	@PutMapping("/update/{email}")
	public ResponseEntity<?> updateEmployee(@PathVariable String email, @RequestBody Employee updatedEmployee) {
		List<Employee> employees = empRepo.findByEmail(email);

		if (employees.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Employee existingEmployee = employees.get(0); // take first match

		existingEmployee.setEmail(updatedEmployee.getEmail());
		existingEmployee.setFullName(updatedEmployee.getFullName());
		existingEmployee.setAddress(updatedEmployee.getAddress());
		existingEmployee.setSalary(updatedEmployee.getSalary());
		existingEmployee.setGender(updatedEmployee.getGender());
		existingEmployee.setHireDate(updatedEmployee.getHireDate());
		existingEmployee.setPassword(updatedEmployee.getPassword());
		existingEmployee.setPhone(updatedEmployee.getPhone());

		empRepo.save(existingEmployee);

		return ResponseEntity.ok(existingEmployee);
	}

	// ✅ Delete employee by ID (Integer)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		if (!empRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
		}
		empRepo.deleteById(id);
		return ResponseEntity.ok("Employee deleted successfully with ID: " + id);
	}
}
