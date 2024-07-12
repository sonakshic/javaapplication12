package com.example.javaresposity;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.javaentity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

//	boolean existsByUsername(String name);

//	boolean existsByEmail(String email);
//	
//	boolean exitsByname(String name);
	
	Optional<Users> findByEmail(String email);

	
}
