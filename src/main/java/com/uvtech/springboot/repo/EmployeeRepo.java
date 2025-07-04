package com.uvtech.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uvtech.springboot.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
