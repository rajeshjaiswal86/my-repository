package com.springboot.crud.service;

import com.springboot.crud.dto.EmpDTO;

public interface CrudService {
	public String createEmployee(EmpDTO dto);

	public String updateEmployee(EmpDTO dto);

	public EmpDTO getEmployee(String empId);

	public String deleteEmployee(String empId);
}
