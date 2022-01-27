package br.com.wesley.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fildeName, String message) {
		this.errors.add(new FieldMessage(fildeName,message));
	}

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestampLong, Integer status, String error) {
		super(timestampLong, status, error);
		// TODO Auto-generated constructor stub
	}
	 
	
	
}
