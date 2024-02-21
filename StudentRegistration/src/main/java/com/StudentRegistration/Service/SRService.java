package com.StudentRegistration.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentRegistration.Modal.Student;
import com.StudentRegistration.Repository.SRRepository;

@Service
public class SRService {
	
	@Autowired
	SRRepository repo;
	
	public ResponseEntity<String> saveStudent(Student stud) {
		try {
			repo.save(stud);
			return new ResponseEntity<>("Sucessfull",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

	public ResponseEntity<List<Student>> getStudents() {
		try {
			List<Student>list=repo.findAll();
			return new ResponseEntity<>(list,HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> updateStudent(Student stud) {
		try {
			repo.save(stud);
			return new ResponseEntity<>("Updated",HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> deleteStudent(int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>("Deleted",HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Student> searchStudent(int id) {
		try {
			Student s=repo.findById(id).get();
			return new ResponseEntity<>(s,HttpStatus.FOUND);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
