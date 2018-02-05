package com.akshay.ManyToManyRelationShip;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="student1")
@Table(name = "Student_Detail")
public class Student
{
	@Id @GeneratedValue
	private int id;
	private String Name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Certification> certifications = new HashSet<Certification>();

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public Set<Certification> getCertifications() {
		return certifications;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setCertifications(Set<Certification> certifications) {
		this.certifications= certifications;
	}

}
