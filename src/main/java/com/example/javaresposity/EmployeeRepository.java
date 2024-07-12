package com.example.javaresposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.javadomain.EmployeeEntity;
import com.example.javadomain.EmployeeRequest;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

//	@Query("SELECT c FROM EmployeeEntity c where c.id=?")
//	java.util.List<EmployeeEntity> findAllFeatures();
	
//	@Query("SELECT c FROM EmployeeEntity c where c.id=?")
//	 List<EmployeeEntity> findAllByAge();
	 
	 @Query("SELECT c FROM EmployeeEntity c where c.id=?1")
   List<EmployeeEntity> findAll(EmployeeRequest capture);

}
