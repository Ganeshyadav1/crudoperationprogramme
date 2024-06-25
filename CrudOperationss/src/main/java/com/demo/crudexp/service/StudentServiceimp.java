package com.demo.crudexp.service;

import java.util.List;

import com.demo.crudexp.dto.Studentdto;

public interface StudentServiceimp {
	public Studentdto add(Studentdto dto);
	public List<Studentdto>getall();
	public Studentdto getById(long empId);
	public Studentdto delateById(long empId);
	public Studentdto updateById(Studentdto dto );


}
