package com.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.JobOpening;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Integer> {

}
