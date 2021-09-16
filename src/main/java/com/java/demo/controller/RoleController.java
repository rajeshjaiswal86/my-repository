package com.java.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/")
public class RoleController {
	@GetMapping("/roles")
	public String getRoles() {
		return "Admin";
	}
}
