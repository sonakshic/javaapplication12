package com.example.javaregistercontroller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.javadomain.LongResponse;
import com.example.javadomain.UserLoginDTO;
import com.example.javadomain.UserRegisteredDTO;
import com.example.javaentity.Users;
import com.example.javaresposity.ExportData;
import com.example.javaresposity.UserRepository;
import com.example.javaservice.CustomAppException;
import com.example.javaservice.HotelService;
import com.example.javaservice.UserDetailsService;
//import com.example.javaservice.UserExcelExporter;
import com.example.javautility.JwtTokenUtil;

@RestController
@RequestMapping(value = "/api/v1")
public class RegisterController {

	@Autowired
	HotelService hotelservice;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDetailsService userdetailsservice;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private ExportData reportService;

//	@PostMapping("/signup")
	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerUser(@RequestBody UserRegisteredDTO signUpRequest) {

		Optional<Users> hotal = userRepository.findByEmail(signUpRequest.getEmail());

		if (hotal.isPresent()) {
			throw new CustomAppException("There is Customer already an account registered with the same email ...!");

		}

		Users res = userdetailsservice.registerhotel(signUpRequest);

		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

	}

//	@RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO loginRequest) {
//
//		Users userLogin = userdetailsservice.login(loginRequest);
//
//		final String token = jwtTokenUtil.generateToken(userLogin);

//		String token = JwtTokenUtil.generateToken(userLogin.getName());

//		return ResponseEntity.ok(new LongResponse(token, "u have been Successfully Login", userLogin));

//		return ResponseEntity.OK(new LongResponse(token));

//		return new ResponseEntity<>(new LongResponse(token), HttpStatus.OK);
//	}

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public void generateExcelReport(HttpServletResponse response) throws Exception {

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment;filename=courses.xls");

		reportService.generateExcel(response);

		response.flushBuffer();
	}

}
