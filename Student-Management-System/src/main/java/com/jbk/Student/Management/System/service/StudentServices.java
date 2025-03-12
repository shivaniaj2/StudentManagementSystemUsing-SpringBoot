package com.jbk.Student.Management.System.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Student.Management.System.dao.StudentDao;
import com.jbk.Student.Management.System.entity.StudentEntity;

@Service
public class StudentServices {

	@Autowired
	StudentDao dao;

	public String insertData(StudentEntity s) {
		String msg = dao.insertData(s);
		if (Objects.isNull(msg)) {
			msg = "data is not inserted...";
		}
		return msg;
	}

	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		return msg;

	}

	public String UpdateData(StudentEntity s, int id) {
		String msg = dao.UpdateData(s, id);
		return msg;
	}

	public StudentEntity getSingleData(int id) {
		StudentEntity s1 = dao.getSingleData(id);
		return s1;

	}

	public List<StudentEntity> getAllData() {
		List<StudentEntity> s1 = dao.getAllData();
		return s1;

	}

}
