package com.akshay.SerializationExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Serial Version UID : 
 * If we are not defining any serial version uid then jvm will automatically created it 
 * based on all property we have in our class. 
 * So if we are not defining any serial version uid and serialize object and after that we add a new property then it will generate new serial version UID based on addition of new Field and deserialization failed.       
 * 
 * Exception in thread "main" java.io.InvalidClassException: 
 * com.akshay.SerializationExample.SerializationWithTransientBreak; 
 * local class incompatible: stream classdesc serialVersionUID = 2566324994913563433, local class serialVersionUID = -738469554570122908


*/
public class SerializationWithTransientBreak implements Serializable {

	private int id;
	private String name;
	private transient float salary;
	private String address;

	public SerializationWithTransientBreak(int id, String name, float salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public SerializationWithTransientBreak(int id, String name, float salary, String address) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();

		// This will write transient variable also.
		out.writeObject(this.salary);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();

		// this will read transient variable
		this.salary = (float) in.readObject();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Id : " + this.id + " Name : " + this.name + " Salary : " + this.salary + " address : " + this.address;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		SerializationWithTransientBreak obj = new SerializationWithTransientBreak(1, "Akshay", 123124f, "Noida");
		System.out.println(obj.toString());
		File f = new File("testSerializeWithTransientBreakDemo.txt");

		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f));
		oo.writeObject(obj);

		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f));
		SerializationWithTransientBreak desObj = (SerializationWithTransientBreak) oi.readObject();

		System.out.println(desObj.toString());
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
