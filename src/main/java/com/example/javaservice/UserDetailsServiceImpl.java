package com.example.javaservice;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.javadomain.LongResponse;
import com.example.javadomain.UserLoginDTO;
import com.example.javadomain.UserRegisteredDTO;
import com.example.javaentity.Role;

import com.example.javaentity.Users;

import com.example.javaresposity.RoleRepository;
import com.example.javaresposity.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	UserRepository userrepo;

	@Autowired
	RoleRepository roleRepo;

//	@Autowired
//	private BCryptPasswordEncoder encryptPass;

//	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public Users registerhotel(UserRegisteredDTO userRegisteredDTO) {

		Users user = new Users();
		user.setEmail(userRegisteredDTO.getEmail());
		user.setName(userRegisteredDTO.getName());
//		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));

		user.setPassword(userRegisteredDTO.getPassword());

		Set<String> strRoles = userRegisteredDTO.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role role = roleRepo.findByRole("ROLE_ADMIN");
			roles.add(role);
		} else {
			Role role = roleRepo.findByRole("ROLE_USER");
			roles.add(role);
		}
		user.setRoles(roles);

		return userrepo.save(user);

	}

	@Override
	public Users login(UserLoginDTO loginData) {

		Optional<Users> user = userrepo.findByEmail(loginData.getEmail());

		if (user == null) {
			throw new CustomAppException("Invalid email or password.");
		}
		LongResponse re = new LongResponse(null);

		return null;

	}

//	@Override
//	public List<Users> getTheListUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Users> getTheListStudent() {
//		// TODO Auto-generated method stub
//
//		return userrepo.findAll();
//	}

//	private Role checkRoleExist() {
//		Role role = new Role();
//		role.setRole("ROLE_ADMIN");
//		return roleRepo.save(role);
//	}

	public ByteArrayInputStream load() {
		List<Users> tutorials = userrepo.findAll();

		ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
		return in;
	}

}
