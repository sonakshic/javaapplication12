package com.example.javaservice;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.example.javadomain.LongResponse;
import com.example.javadomain.UserLoginDTO;
import com.example.javadomain.UserRegisteredDTO;

import com.example.javaentity.Users;

public interface UserDetailsService {

	Users registerhotel(UserRegisteredDTO holtelequest);

	Users login(UserLoginDTO loginData);

//	List<Users> getTheListUsers();

	ByteArrayInputStream load();
}
