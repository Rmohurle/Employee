package com.myapp.EmployeeData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.EmployeeData.entity.Employee;

@Repository
public interface EmployeeReepository extends JpaRepository<Employee, Long> {

}
