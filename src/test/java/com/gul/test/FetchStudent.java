package com.gul.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gul.config.JpaConfig;
import com.gul.entity.Student;
import com.gul.repo.StudentRepository;
import com.kgate.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
//@ContextConfiguration(locations = "classpath:appcontext.xml")
@WebAppConfiguration
public class FetchStudent {

	@Autowired
	StudentService service;
	@Autowired
	StudentRepository repo;

	private static Logger log = Logger.getLogger(FetchStudent.class);

//	@Test
//	public void testAddDepartment() {
//		
//		List<Student> li = service.findAll();
//		for (Student student : li) {
//			System.out.println("List: " + student.getFname());
//			System.out.println("List: " + student.getLname());
//			System.out.println("List: " + student.getEmail());
//		}
//	}
	@Test
	public void logn() {

		Student std = repo.findByEmailAndPassword("gulfarooqui1@gmail.com", "1234");
		if (std == null) {
			log.info("Invalid");
			System.out.println("Invalid");
		} else {
			log.info("Successfully Login");
			System.out.println("Successfully login");
		}
	}
}
