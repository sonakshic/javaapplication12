package com.example.javaservice;

import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javadomain.HoltelRequest;
import com.example.javaenums.ERole;
import com.example.javamodel.Hotelmodel;

import com.example.javaresposity.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	private static final Logger LOG = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	HotelRepository hotelrepository;

	@Override
	public Hotelmodel registerhotel(HoltelRequest holtelequest) {

		Hotelmodel emp = new Hotelmodel();

		Optional<Hotelmodel> hotal = hotelrepository.findByEmail(holtelequest.getEmail());

		if (hotal.isPresent()) {
			throw new CustomAppException("There is Customer already an account registered with the same email ...!");

		}

//		Role roleType = Role.fromString(holtelequest.getRole());
//
//		if (roleType == null || (roleType != Role.ROLE_ADMIN && roleType != Role.ROLE_CUSTOMER)) {
//			LOG.error("Found invalid UserType: {}.", holtelequest.getRole());
//			throw new CustomAppException("Invalid request: invalid role type: " + holtelequest.getRole());
//		}

		emp.setFirstname(holtelequest.getFirstname());
//		emp.setPassword(password);
		emp.setEmail(holtelequest.getEmail());
		emp.setDob(holtelequest.getDob());
		emp.setPhone(holtelequest.getPhone());
//		emp.setGender(holtelequest.getGender());
//		emp.setRole(Role.ROLE_CUSTOMER);
//		emp.setRole(Role.ROLE_CUSTOMER);
		

		LOG.info("Registration successfull");
		Hotelmodel fcat = hotelrepository.save(emp);

		return fcat;

	}

	private boolean matchesRegex(String input) {
		if (input.length() < 8)
			return false;
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		return Pattern.compile(regex).matcher(input).matches();
	}

}
