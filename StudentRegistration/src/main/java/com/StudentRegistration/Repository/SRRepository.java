package com.StudentRegistration.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.StudentRegistration.Modal.Student;

public interface SRRepository extends MongoRepository<Student,Integer>{

}
