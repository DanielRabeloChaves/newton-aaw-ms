package com.newton.aaw.hr.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.domain.repository.EmployeeRepository;
import com.newton.aaw.hr.exception.NotFoundException;

import org.springframework.stereotype.Service;

@Service                  
public class EmployeeService {
	
		private final EmployeeRepository employeeRepository;  
		                                                
		public EmployeeService(EmployeeRepository employeeRepository) {
			this.employeeRepository = employeeRepository;
		}
		
		public Employee create(Employee e) { 
			
			
			e.setStartDate(LocalDateTime.now()); 
			e.setEndDate(LocalDateTime.now()); 
			e.setDateOfBirth(LocalDateTime.now()); 
			
			employeeRepository.save(e);   
			
			return e;	
		}
		
		public Employee update(String id, Employee e) { 
			
			
			var existing = get(id);
			
			existing.setFirstName(e.getFirstName());
			existing.setLastName(e.getLastName());
			existing.setGender(e.getGender());
			existing.setPosition(e.getPosition());
			existing.setMonthlySalary(e.getMonthlySalary());
			existing.setHourSalary(e.getHourSalary());
			existing.setArea(e.getArea());
			
			
			existing.setDateOfBirth(LocalDateTime.now()); 
			
			employeeRepository.save(existing); 
			
			return existing;
		}
		
		public Employee get(String id) { 
			
			var employee = employeeRepository.findById(id); 
			
			if (employee.isEmpty()) { 
				throw new NotFoundException("User with ID"+ id + "not Found"); 
			}
			return employee.get(); 
		}
		
		
		public List<Employee> getAll(){ 
			
			return employeeRepository.findAll();  
		}
		
		
		public void delete(String id) { 
			
			
			get(id); 
			
			employeeRepository.deleteById(id); 
		}
}