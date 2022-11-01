package com.techno.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.mapping.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	

}
