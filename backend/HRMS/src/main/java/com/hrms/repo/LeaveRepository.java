package com.hrms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	Optional<Leave> findByEmail(String email);
	
	Optional<Leave> findBySrNoAndEmail(int srNo, String email);
}
