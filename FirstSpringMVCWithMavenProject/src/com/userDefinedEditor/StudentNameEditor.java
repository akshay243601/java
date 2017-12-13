package com.userDefinedEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Controller;

@Controller
public class StudentNameEditor extends PropertyEditorSupport
{

	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		
		if(studentName != null && (studentName.contains("Mr.") || studentName.contains("Ms.")))
		{
			setValue(studentName);
		}
		else
		{
			studentName = "Mr. "+studentName;
			setValue(studentName);
		}
	}
}
