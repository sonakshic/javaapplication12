package com.example.javacontroller;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.javadomain.EmployeeEntity;
import com.example.javadomain.EmployeeRequest;
import com.example.javaresposity.EmployeeRepository;
import com.example.javaservice.EmployeeService;
import com.example.javaservice.EmpolyeeValidation;
import com.example.javavalidation.Validation;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	Validation validation;

	@Autowired
	EmpolyeeValidation empolyeeValidation;

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value = "/creat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeEntity> create(@RequestBody EmployeeRequest capture) throws Exception {
		empolyeeValidation.createEmpolyeeValidation(capture);
		EmployeeEntity resp = employeeService.createEmployee(capture);
		return new ResponseEntity<>(resp, HttpStatus.OK);

	}

//	@RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) throws Exception {

		try {

			EmployeeEntity emp = employeeService.getemploye(id);
			if (emp != null) {
				return new ResponseEntity<>(emp, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			LOG.error("Response code should be 500", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

  @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@GetMapping(value = "/getAllEmployee")
	public  ResponseEntity<List<EmployeeEntity>> getAllEmployee() throws Exception {

		List<EmployeeEntity> userList = employeeService.getAllUsers();
		LinkedHashMap<String, Object> map1 = new LinkedHashMap<String, Object>();
		map1.put("users", userList);
		return new ResponseEntity<>(userList, HttpStatus.OK);

	}
  
  

}
