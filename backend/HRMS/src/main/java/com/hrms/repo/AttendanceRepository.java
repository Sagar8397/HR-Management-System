package com.hrms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	List<Attendance> findByEmail(String email);
}
