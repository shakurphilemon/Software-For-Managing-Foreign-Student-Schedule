package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//This handler method is to handle student list and return mode view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";

	}
	@GetMapping("students/new")
	public String createStudentForm (Model model) {
		//This creates an object to hold students form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/students")
	public String saveStudent (@ModelAttribute("student") Student student){
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentsForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentsById(id));
		return "edit_student";

	}

	@PostMapping("/students/{id}")
	public  String updateStudent( @PathVariable  Long id,
								  @ModelAttribute("student") Student student, Model model) {
		//This will get foreign student from MySQL database by ID
		Student existingStudent = studentService.getStudentsById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		//This will then save the update after we make changes to it
		studentService.updateStudent(existingStudent);
		return "redirect:/students";

	}

	//Method to delete student from the database
	@GetMapping("/students/{id}")
	public String studentDelete(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";

	}

}
