package com.example.javaresposity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.javaentity.Role;
import com.example.javaenums.ERole;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String name);

}
