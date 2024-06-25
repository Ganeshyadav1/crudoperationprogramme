package com.demo.crudexp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 

public class Studentdto {

	private long id;
	private String name;
	private String fathername;
	private long mobile;


}
