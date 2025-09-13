package com.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Salaries;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Integer> {

}
