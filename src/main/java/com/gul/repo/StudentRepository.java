package com.gul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmailAndPassword(String email,String password);
}
