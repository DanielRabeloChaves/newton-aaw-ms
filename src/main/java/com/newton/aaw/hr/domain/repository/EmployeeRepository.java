package com.newton.aaw.hr.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newton.aaw.hr.domain.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
