package CustomValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;
import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby  
{
	String listOfStudentHobby() default "Hockey|Cricket";
	
	String message() default "Please provide hobby in one of them Cricket, Music and Hockey";
	
	
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
