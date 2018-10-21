package com.springboot.crud.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.dto.EmpDTO;
import com.springboot.crud.dto.EmpEntity;
import com.springboot.crud.repository.CrudRepository;

@Service
public class CrudServiceImpl implements CrudService {
	@Autowired
	CrudRepository repository;

	@Override
	public String createEmployee(EmpDTO dto) {
		EmpEntity entity = new EmpEntity();
		String message = "";
		BeanUtils.copyProperties(dto, entity);
		try {
			entity = repository.save(entity);
			message = "Success";
		} catch (Exception ex) {
			message = "Fail";
		}
		return message;
	}

	@Override
	public String updateEmployee(EmpDTO dto) {
		EmpEntity entity = new EmpEntity();
		String message = "";
		BeanUtils.copyProperties(dto, entity);
		try {
			entity = repository.save(entity);
			message = "Success";
		} catch (Exception ex) {
			message = "Fail";
		}
		return message;
	}

	@Override
	public EmpDTO getEmployee(String empId) {
		EmpEntity entity = repository.findById(empId).get();
		EmpDTO dto = new EmpDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public String deleteEmployee(String empId) {
		repository.deleteById(empId);
		return "Success";
	}

}
