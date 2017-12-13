package com.akshay.Comparable;

public class User implements Comparable<User> 
{
	private int Id;
	
	private String Name;
	
	private String City;
	
	public User(int Id, String Name, String City)
	{
		this.Id = Id;
		this.Name = Name;
		this.City = City;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getCity() {
		return City;
	}
	
	public void setCity(String city) {
		City = city;
	}
	
	public String toString()
	{	
		return  "Id :-   " + this.Id + "  , Name :-  " + this.Name + "  , City :-   " + this.City;
	}


	@Override
	public int compareTo(User user) 
	{
		User temp = this;
		int i = temp.getName().compareTo(user.getName());
		if(i == 0)
		{
			i = temp.getCity().compareTo(user.getCity());
		}
		return i;
	}
	
}
