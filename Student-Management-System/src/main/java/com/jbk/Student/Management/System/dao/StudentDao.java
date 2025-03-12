package com.jbk.Student.Management.System.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Student.Management.System.entity.StudentEntity;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(StudentEntity s) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(s);
			tx.commit();
			msg = "Data is inserted successfully....";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();

			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return msg;
	}

	public String deleteData(int id) {

		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		StudentEntity s1 = session.get(StudentEntity.class, id);
		session.remove(s1);
		tr.commit();
		session.close();

		return "Data is Deleted Successfully...";

	}

	public String UpdateData(StudentEntity s, int id) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();

		StudentEntity s1 = session.get(StudentEntity.class, id);
		s1.setName(s.getName());
		s1.setAge(s.getAge());

		session.merge(s1);
		tr.commit();
		session.close();

		return "Data is Updated Successfully...";

	}

	public StudentEntity getSingleData(int id) {
		Session session = factory.openSession();
		StudentEntity s1 = session.get(StudentEntity.class, id);
		session.close();
		return s1;

	}

	public List<StudentEntity> getAllData() {
		Session session = factory.openSession();
		List<StudentEntity> s1 = session.createQuery("From StudentEntity", StudentEntity.class).list();
		session.close();
		return s1;
	}

}
