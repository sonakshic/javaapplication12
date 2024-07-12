package com.example.javaservice;

import java.util.List;

import com.example.javadomain.EmployeeEntity;
import com.example.javadomain.EmployeeRequest;

public interface EmployeeService {

	EmployeeEntity createEmployee(EmployeeRequest param) throws Exception;

	EmployeeEntity getemploye(Long id);

	List<EmployeeEntity> getAllUsers();

	

	

}
