package com.springboot.crud.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_details")
public class EmpEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "empId")
	private String empId;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private Double salary;
	@Column(name = "dob")
	private String dob;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
