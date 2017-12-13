package com.GlobalExceptionHandlerpkg;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



//You can configure the same thing in Config file. So  that you need not to write the long java code class.
@ControllerAdvice
public class GlobalExceptionHandlerClass 
{
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e)
	{
		System.out.println("Null Pointer exception occurs");
		return "NullPointerException";
	}
	
	@ExceptionHandler(value=IOException.class)
	public String handleIOException(Exception e)
	{
		System.out.println("IO exception occurs");
		return "IOException";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e)
	{
		System.out.println("Exception occurs");
		return "Exception";
	}

}


//If you want to perform a StatusCode then you need to set the ResponseStatusCode.