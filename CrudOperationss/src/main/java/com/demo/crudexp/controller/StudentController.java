package com.demo.crudexp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crudexp.entity.Student;
import com.demo.crudexp.exception.StudentNotFoundException;
import com.demo.crudexp.service.StudentService;


@RestController
//@RequestMapping("/stud")
public class StudentController{
	@Autowired
 private StudentService studentservice;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllData(){
		List<Student> st=studentservice.getAllData();
		return new ResponseEntity<>(st, HttpStatus.OK);
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
	Student st = studentservice.getDataById(id);
	if(st==null) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("students")//studentss
	public ResponseEntity<Student> saveorUpdate(@RequestBody Student student){
		studentservice.saveorUpdate(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
		Student updateStudent=studentservice.getDataById(id);
			if(updateStudent==null) {
				throw new StudentNotFoundException("Student Not Found" + id);
			}
		updateStudent.setName(student.getName());
		updateStudent.setFathername(student.getFathername());
		updateStudent.setMobile(student.getMobile());
		
		studentservice.saveorUpdate(updateStudent);
		return ResponseEntity.ok(updateStudent);

	}
	@DeleteMapping("{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id){
		studentservice.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
