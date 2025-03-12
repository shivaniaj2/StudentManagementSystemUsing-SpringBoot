package com.jbk.Student.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Student.Management.System.entity.StudentEntity;
import com.jbk.Student.Management.System.service.StudentServices;

@RestController
public class StudentController {
	
	@Autowired
	StudentServices service;
	
	@PostMapping("/StudentDataSave")
	public String insertData(@RequestBody StudentEntity s) {
		String msg=service.insertData(s);
		return msg;
	}
	@DeleteMapping("/StudentDataDelete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;
		
	}
	
	@PutMapping("/StudentDataUpdate/{id}")
	public String UpdateData(@RequestBody StudentEntity s,@PathVariable int id) {
		String msg=service.UpdateData(s, id);
		return msg;
		
	}
	
	@GetMapping("/StudentFetchSingleData/{id}")
	public StudentEntity getSingleData(@PathVariable int id) {
		StudentEntity s1=service.getSingleData(id);
		return s1;
	}
	
	@GetMapping("/GetAllData")
	public List<StudentEntity> getAllData() {
		List<StudentEntity>s1=service.getAllData();
		return s1;
	}

}
