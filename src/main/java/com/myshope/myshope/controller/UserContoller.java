package com.myshope.myshope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myshope.myshope.entity.UserEntity;
import com.myshope.myshope.service.UserService;
import com.myshope.myshope.serviceimpl.MailService;

@Controller
public class UserContoller {

	@Autowired
	private UserService employeeService;
	
	@Autowired
	MailService mailservice;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.findAll());
		return "index";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		UserEntity employee = new UserEntity();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") UserEntity employee) {
		// save employee to database
		employeeService.add(employee);
		mailservice.sendEmail(employee.getEmail(), employee.getName(), "You Are Register Successfully !");
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		UserEntity employee = employeeService.findOne(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.employeeService.delete(id);;
		return "redirect:/";
	}

}
