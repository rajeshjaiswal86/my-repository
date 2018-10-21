package com.springboot.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.crud.dto.EmpDTO;
import com.springboot.crud.service.CrudService;

@Controller
@RequestMapping(value = "/service")
public class CrudController {
	@Autowired
	CrudService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> createEmployee(@RequestBody EmpDTO dto) {
		return new ResponseEntity<String>(service.createEmployee(dto), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody EmpDTO dto) {
		return new ResponseEntity<String>(service.updateEmployee(dto), HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{empId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<EmpDTO> getEmployee(@PathVariable String empId) {
		return new ResponseEntity<EmpDTO>(service.getEmployee(empId), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> deleteEmployee(@PathVariable String empId) {
		return new ResponseEntity<String>(service.deleteEmployee(empId), HttpStatus.OK);
	}
}
