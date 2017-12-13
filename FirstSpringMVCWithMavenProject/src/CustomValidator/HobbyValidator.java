package CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>
{
	private String listOfHobby;

	@Override
	public void initialize(IsValidHobby isValidHobby) 
	{
		this.listOfHobby = isValidHobby.listOfStudentHobby();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) 
	{
		if(studentHobby == null)
		{
			return false;
		}
		
		if(studentHobby.matches(listOfHobby))
		{
			return true;
		}	
		return false;
	}
}
