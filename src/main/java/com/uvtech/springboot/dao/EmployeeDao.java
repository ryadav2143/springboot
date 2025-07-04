package com.uvtech.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uvtech.springboot.dto.Employee;
import com.uvtech.springboot.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeRepo repo;

    public Employee saveEmployee(Employee employee){
        return repo.save(employee);
    }

    public Employee fetchEmployee(int id){
        Optional<Employee> optional=repo.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        else{
            return optional.get();
        }
    }

    public List<Employee> fetchAll(){
        return repo.findAll();
    }

    public Employee deleteEmployee(Employee employee){
        repo.delete(employee);
        return employee;
    }


}
