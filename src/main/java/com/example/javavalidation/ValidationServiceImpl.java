package com.example.javavalidation;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.javadomain.Constant;
import com.example.javadomain.EmployeeRequest;

@Service
public class ValidationServiceImpl implements Validation {

	private static final Logger LOG = LoggerFactory.getLogger(ValidationServiceImpl.class);

	public String validationofemployee(EmployeeRequest param) {
		if (Objects.isNull(param)) {
			LOG.error("employe is null");
			return "Request Order Object  is null";
		}
		if (param.getAddress() == null || param.getAddress().isEmpty()) {
			LOG.error("mandatory fields are missing");
			return "mandatory fields are missing null or empty";
		}

		if (param.getName() == null || param.getName().isEmpty()) {
			LOG.error("mandatory fields are missing");
			return "mandatory fields are missing null or empty";
		}
		return Constant.VALIDATION_ERROR;

	}

}
