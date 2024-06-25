package com.demo.crudexp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crudexp.dto.Studentdto;
import com.demo.crudexp.entity.Student;
import com.demo.crudexp.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceimp{

	@Autowired
	public StudentRepository studentRepository;
	
	public List<Student> getAllData(){
		return (List<Student>) studentRepository.findAll();
	} 
	
	public void deleteById(long id) {
		studentRepository.deleteById(id);
	}
	
	public Student getDataById(long id) {
		Optional<Student> st =studentRepository.findById(id);
		return st.orElse(null);
	}
	
	public void saveorUpdate(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Studentdto add(Studentdto dto) {
		return null;
	}

	@Override
	public List<Studentdto> getall() {
		return null;
	}

	@Override
	public Studentdto getById(long empId) {
		return null;
	}

	@Override
	public Studentdto delateById(long empId) {
		return null;
	}

	@Override
	public Studentdto updateById(Studentdto dto) {
		return null;
	}
	
	
}
