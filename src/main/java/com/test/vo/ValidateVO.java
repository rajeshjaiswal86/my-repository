package com.test.vo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author Rajesh
 *
 */
public class ValidateVO {
	@JsonProperty
	private boolean errorFlag;
	private List<String> errorList;
	public boolean isErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
}
