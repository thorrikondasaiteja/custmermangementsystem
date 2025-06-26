package com.vcube.SpringBootJpa.Exception;

public class ResourceNotFoundexception extends Exception{
	public ResourceNotFoundexception(String s){
		super(s);
	}

	 public ResourceNotFoundexception(String message, Throwable cause) {
	        super(message, cause);
	    }

	    // ✅ Optional: Default constructor
	    public ResourceNotFoundexception() {
	        super("Resource not found");
	    }
	}
	


