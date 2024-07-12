package com.example.javaservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javadomain.Constant;
import com.example.javadomain.EmployeeEntity;
import com.example.javadomain.EmployeeRequest;
import com.example.javaresposity.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeEntity createEmployee(EmployeeRequest param) throws Exception {
		// TODO Auto-generated method stub

		EmployeeEntity emp = new EmployeeEntity();
		emp.setAddress(param.getAddress());
		emp.setDateOfBirth(param.getDateOfBirth());
		emp.setGender(param.getGender());
		emp.setName(param.getName());
        emp.setPassword(param.getPassword());
		EmployeeEntity fcat = employeeRepository.save(emp);

		return fcat;
	}

	@Override
	public EmployeeEntity getemploye(Long id) {

		Optional<EmployeeEntity> pet = employeeRepository.findById(id);
		if (pet.isPresent()) {
			return pet.get();
		} else {
			throw new CustomAppException("entity does not exist", Constant.ENTITY_NOT_EXIST);
		}

	}

	@Override
	public List<EmployeeEntity> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<EmployeeEntity> feature = employeeRepository.findAll();
		
		return feature;
	}

	

}
