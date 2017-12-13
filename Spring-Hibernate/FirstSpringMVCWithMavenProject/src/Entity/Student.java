package Entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import CustomValidator.IsValidHobby;


public class Student 
{
	@Pattern(regexp="[^0-9]*")
	private String name;
	
	@Size(min=5, max=40) @IsValidHobby(listOfStudentHobby="Hockey|Music|Cricket")
	private String hobby;
	
	//@Min(10)
	@Max(9999)
	private long mobile;
	
	
	//@Future
	@Past
	private Date dob ;
	
	private List<String> skills;
	
	private Address studentsAddress;
	
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Address getStudentsAddress() {
		return studentsAddress;
	}

	public void setStudentsAddress(Address studentsAddress) {
		this.studentsAddress = studentsAddress;
	}	
}
