package com.akshay.hibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class StudentDetail {
	
	@Id @GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator" , strategy="foreign", parameters={@Parameter(value="student", name="property")}) // this line of code will stop for Hibernate to create diff. Id. By using this Hibernate create the same Id which is created for Student table
	//@Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
	private int studentId;
	
	private String studentMobile;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@OneToOne(cascade = CascadeType.ALL) //If you want to perform all the operation into related table done automaticlly then we use ALL.
	@JoinColumn(name="studentId") //It is the studentId of Student Class. Here we declare it as a Foreign key for StudentDetails class
	private Student student;
	
	public Student getstudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getstudentMobile() {
		return studentMobile;
	}
	
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}
}
