package com.uvtech.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.uvtech.springboot.dao.EmployeeDao;
import com.uvtech.springboot.dto.Employee;
import com.uvtech.springboot.exception.IdNotFoundException;
import com.uvtech.springboot.exception.NoDataFoundException;
import com.uvtech.springboot.repo.EmployeeRepo;
import com.uvtech.springboot.util.ResponseStruture;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeDao dao;

    EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public ResponseEntity<ResponseStruture<Employee>> saveEmployee(Employee employee){
        double salary=employee.getSalary();
        if(salary>=40000){
            employee.setGrade('A');
        }else if(salary>=30000){
            employee.setGrade('B');
        }else if(salary>=20000){
            employee.setGrade('C');
        }else{
            employee.setGrade('D');
        }
        Employee emp1=dao.saveEmployee(employee);
        ResponseStruture<Employee> struture=new ResponseStruture<>();
        struture.setData(emp1);
        struture.setMessage("Employee data saved");
        struture.setStatus(HttpStatus.CREATED.value());

        return new ResponseEntity<ResponseStruture<Employee>>(struture,HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStruture<Employee>> fetchEmployee(int id){
        Employee employee=dao.fetchEmployee(id);
        if(employee!=null){
             ResponseStruture<Employee> structure=new ResponseStruture<>();
             structure.setMessage("Employee Data found");
             structure.setStatus(HttpStatus.FOUND.value());
             structure.setData(employee);
             return new ResponseEntity<ResponseStruture<Employee>>(structure,HttpStatus.FOUND);
        }else{
            throw new IdNotFoundException();
        }

    }

    public ResponseEntity<ResponseStruture<List<Employee>>> fetchAll(){
        List<Employee> employee=dao.fetchAll();
        if(!employee.isEmpty()){
           ResponseStruture<List<Employee>> structure=new ResponseStruture<>();
           structure.setMessage("Data found");
           structure.setStatus(HttpStatus.FOUND.value());
           structure.setData(employee);
           return new ResponseEntity<ResponseStruture<List<Employee>>>(structure,HttpStatus.FOUND);
        }
        else{
            throw new NoDataFoundException();
        }

    }

    public ResponseEntity<ResponseStruture<Employee>> deleteEmployee(int id){
        Employee empployee=dao.fetchEmployee(id);
        if(empployee!=null){
            Employee employee2=dao.deleteEmployee(empployee);
            ResponseStruture<Employee> structure=new ResponseStruture<>();
           structure.setMessage("Data found");
           structure.setStatus(HttpStatus.OK.value());
           structure.setData(employee2);
           return new ResponseEntity<ResponseStruture<Employee>>(structure,HttpStatus.OK);            

        }else{
            throw new IdNotFoundException();
        }
    }

    public ResponseEntity<ResponseStruture<Employee>> updateSalary(int id, double salary) {
        Employee employee=dao.fetchEmployee(id);
        if(employee!=null){
            Employee employee2=new Employee();
            employee2.setId(id);
            employee2.setName(employee.getName());
            employee2.setAddress(employee.getAddress());
            employee2.setPhone(employee.getPhone());
            employee2.setSalary(salary);
            if(salary>=40000){
                employee2.setGrade('A');
            }else if(salary>=30000){
                employee2.setGrade('B');
            }else if(salary>=20000){
                employee2.setGrade('C');
            }else{
                employee2.setGrade('D');
            }
            Employee employee3=dao.saveEmployee(employee2);
            ResponseStruture<Employee> struture=new ResponseStruture<>();
            struture.setData(employee3);
            struture.setStatus(HttpStatus.OK.value());
            struture.setMessage("Salary Updated");

            return new ResponseEntity<ResponseStruture<Employee>>(struture,HttpStatus.OK);

        }else{
            throw new IdNotFoundException();
        }
        
    }

    public ResponseEntity<ResponseStruture<Employee>> updateEmployee(int id, Employee employee) {
        Employee emp=dao.fetchEmployee(id);
        if(emp!=null){
            emp.setName(employee.getName());
            emp.setAddress(employee.getAddress());
            emp.setPhone(employee.getPhone());
            emp.setSalary(employee.getSalary());
              if(employee.getSalary()>=40000){
                emp.setGrade('A');
            }else if(employee.getSalary()>=30000){
                emp.setGrade('B');
            }else if(employee.getSalary()>=20000){
                emp.setGrade('C');
            }else{
                emp.setGrade('D');
            }
            Employee employee3=dao.saveEmployee(emp);
            ResponseStruture<Employee> struture=new ResponseStruture<>();
            struture.setData(employee3);
            struture.setStatus(HttpStatus.OK.value());
            struture.setMessage("EMployee Updated");

            return new ResponseEntity<ResponseStruture<Employee>>(struture,HttpStatus.OK);

        }else{
            throw new IdNotFoundException();
        }
    }

}
