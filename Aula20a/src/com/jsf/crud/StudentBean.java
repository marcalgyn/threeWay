package com.jsf.crud;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jsf.crud.db.operations.DatabaseOperation;
import com.jsf.entidade.Student;

@ManagedBean 
@RequestScoped
public class StudentBean {


	public ArrayList<Student>studentsListFromDB;
	private Student Student = new Student();


	
	@PostConstruct
	public void init() {
		studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

	public ArrayList<Student> studentsList() {
		return studentsListFromDB;
	}
	
	public String saveStudentDetails(Student newStudentObj) {
		return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
	}
	
	public String editStudentRecord(int studentId) {
		return DatabaseOperation.editStudentRecordInDB(studentId);
	}
	
	public String updateStudentDetails(Student updateStudentObj) {
		return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
	}
	
	public String deleteStudentRecord(int studentId) {
		return DatabaseOperation.deleteStudentRecordInDB(studentId);
	}

	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student student) {
		Student = student;
	}
}