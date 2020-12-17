package edu.miu.student.controller.nayGaema;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * This DTO wraps those validation errors together
 * @author rXing
 *
 */
public class ValidationErrorDTO {
	private String errorType;
	private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

	public ValidationErrorDTO() {

	}

	public ValidationErrorDTO(String errorType) {
		this.errorType = errorType;
	}

	public void addFieldError(String path, String errors) {
		FieldErrorDTO error = new FieldErrorDTO(path,errors);
		fieldErrors.add(error);
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
