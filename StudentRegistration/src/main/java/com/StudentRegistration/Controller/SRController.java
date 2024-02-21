package com.StudentRegistration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentRegistration.Modal.Student;
import com.StudentRegistration.Service.SRService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/students")
public class SRController {
	
	@Autowired
	SRService service;
	
	@PostMapping("save")
	public ResponseEntity<String> saveStudent(@RequestBody Student stud) {
		return service.saveStudent(stud);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Student>> getStudents() {
		return service.getStudents();
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateStudent(@RequestBody Student stud) {
		return service.updateStudent(stud);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	
	@RequestMapping("search/{id}")
	public ResponseEntity<Student> searchStudent(@PathVariable int id) {
		return service.searchStudent(id);
	}
}
