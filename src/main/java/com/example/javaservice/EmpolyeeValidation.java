package com.example.javaservice;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.javadomain.Constant;
import com.example.javadomain.EmployeeRequest;

@Component
public class EmpolyeeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

	private boolean checkInputString(String input) {
		return (input == null || input.trim().length() == 0);
	}

	public void createEmpolyeeValidation(EmployeeRequest capture) {
		// TODO Auto-generated method stub
		if ((checkInputString(capture.getAddress())) || (checkInputString(capture.getGender()))) {
			throw new CustomAppException("mandatory fields are missing", Constant.MISSING_MANDATORY_FIELDS);
		}
		


	}

}
