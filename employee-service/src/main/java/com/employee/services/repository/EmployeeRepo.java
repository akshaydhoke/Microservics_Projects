package com.employee.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.services.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

//	@Override
//	default Optional<Employee> findById(Integer id) {
//		return Optional.empty();
//	}

}
