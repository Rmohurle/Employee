package com.myapp.EmployeeData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.EmployeeData.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
