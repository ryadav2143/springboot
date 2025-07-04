package com.uvtech.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uvtech.springboot.dto.Employee;
import com.uvtech.springboot.service.EmployeeService;
import com.uvtech.springboot.util.ResponseStruture;

import jakarta.validation.Valid;

@RestController
public class EmployeeCOntroller {

    @Autowired
    private EmployeeService service;
    @PostMapping("/save")
    public ResponseEntity<ResponseStruture<Employee>> saveEmployee(@RequestBody @Valid Employee employee){
        return service.saveEmployee(employee);

    }

    //  @GetMapping("/fetch/{id}")
    // public ResponseEntity<ResponseStruture<Employee>> fetchEmployee(@PathVariable int id){
    //     return service.fetchEmployee(id);
    // }

    @GetMapping("/fetchAll")
    public ResponseEntity<ResponseStruture<List<Employee>>> fetchAll(){
        return service.fetchAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStruture<Employee>> deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    @PatchMapping("/update/{id}/{salary}")
    public ResponseEntity<ResponseStruture<Employee>> updateSalary(@PathVariable int id, @PathVariable double salary){
        return service.updateSalary(id,salary);

    }
     
    @PutMapping("/updateAll/{id}")
    public ResponseEntity<ResponseStruture<Employee>> updateEmployee(@PathVariable int id,@RequestBody @Valid Employee employee){
        return service.updateEmployee(id,employee);

    }
}
