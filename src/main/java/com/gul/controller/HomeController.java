package com.gul.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Student;
import com.gul.repo.StudentRepository;

@Controller
public class HomeController {

	@Autowired
	StudentRepository repo;

	private Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping("/home")
	public String view() {
		logger.info("View method called");
		System.out.println("testing");
//		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
//		String exp = "";
//		CronTrigger trigger = new CronTrigger("test",timeZone);
		return "index";
	}

	@GetMapping(value = { "/", "add" })
	public String home(Model model) {
		model.addAttribute("student", new Student());
		return "home";
	}

	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("home");
		repo.save(student);
		mav.addObject("student", new Student());
		return mav;
	}

	@GetMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		List<Student> list = repo.findAll();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("update")
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("home");
		Optional<Student> student = repo.findById(id);
		mav.addObject("student", student);
		return mav;
	}

	@GetMapping("delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("list");
		repo.deleteById(id);
		List<Student> list = repo.findAll();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("test")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("student", new Student());
		return mav;
	}

}
