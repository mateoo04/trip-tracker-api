package com.mateo.trip_tracker_api.service;

import com.mateo.trip_tracker_api.api.model.Employee;
import com.mateo.trip_tracker_api.exception.DatabaseFetchingException;
import com.mateo.trip_tracker_api.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> expenseCategory = employeeRepository.findById(id);
        return expenseCategory.orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return employeeRepository.save(employee);
        }else throw new DatabaseFetchingException("Employee not found");
    }

    public void deleteEmployeeById(Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }else throw new DatabaseFetchingException("Employee not found");
    }
}
