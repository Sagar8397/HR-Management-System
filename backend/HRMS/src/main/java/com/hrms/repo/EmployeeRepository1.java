package com.hrms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Employee;

@Repository
public interface EmployeeRepository1 extends JpaRepository<Employee, Integer>{
	
	Employee findByEmail(String email);
	
	Optional<Employee> findByEmailAndPassword(String email, String password);
}
