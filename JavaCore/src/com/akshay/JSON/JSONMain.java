package com.akshay.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;


public class JSONMain 
{
	public static String FILE_PATH = "D:/Study/Dust/jsonObject.txt";
	
	public static void readJsonDataFromFile() throws FileNotFoundException
	{
		FileInputStream fis = new FileInputStream(new File(FILE_PATH));
		JsonReader jsonReader = Json.createReader(fis);
		JsonObject jsonObject = jsonReader.readObject();
		Employee emp = new Employee();	
		emp.setId(jsonObject.getInt("id"));
		emp.setName(jsonObject.getString("Name"));
		emp.setDepartment(jsonObject.getString("Department"));
		JsonObject addressJsonObject = jsonObject.getJsonObject("address");
		Address address = new Address();
		address.setAddressId(addressJsonObject.getInt("addressId"));
		address.setAddressname(addressJsonObject.getString("Addressname"));
		emp.setAddress(address);
		
		System.out.println("Employee Name :--->  " + emp.getName());
		System.out.println("Address Name :--->  " + emp.getAddress().getAddressname());
		
	}
	
	public static void writeJsonDataIntoFile() throws FileNotFoundException
	{
		
		
		Employee emp = new Employee();	
		emp.setId(12);
		emp.setName("Akshay");
		emp.setDepartment("Oracle India Pvt. Ltd.");
		Address address = new Address();
		address.setAddressId(123);
		address.setAddressname("Hyderabad");
		emp.setAddress(address);
		
		FileOutputStream fos = new FileOutputStream(new File(FILE_PATH));
		JsonWriter jsonWriter = Json.createWriter(fos);
		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
		jsonObjectBuilder.add("id", emp.getId());
		jsonObjectBuilder.add("Name", emp.getName());
		jsonObjectBuilder.add("Department", emp.getDepartment());
		JsonObjectBuilder addressJsonaddressBuilder = Json.createObjectBuilder();
		addressJsonaddressBuilder.add("addressId", emp.getAddress().getAddressId());
		addressJsonaddressBuilder.add("Addressname", emp.getAddress().getAddressname());
		
		jsonObjectBuilder.add("address", addressJsonaddressBuilder);
		
		JsonObject jsonObject = jsonObjectBuilder.build();
		jsonWriter.writeObject(jsonObject);
		jsonWriter.close();

	
		
		System.out.println("Employee Name :--->  " + emp.getName());
		System.out.println("Address Name :--->  " + emp.getAddress().getAddressname());

		
	}
	
	public static void main(String args[])
	{
		try {
			writeJsonDataIntoFile();
			
			readJsonDataFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
