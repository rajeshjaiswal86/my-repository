package com.migration.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migration.models.User;
import com.migration.services.MysqlDataService;
import com.migration.services.PostgresDataService;

@RestController
public class MigrateUserController {
	private final Logger logger = LoggerFactory.getLogger(MigrateUserController.class);

	@Autowired
	private PostgresDataService postgresDataService;
	@Autowired
	private MysqlDataService mysqlDataService;

	@GetMapping(value = "/mysql/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getMysqlUser() {
		List<User> users = mysqlDataService.listUsers();
		if (users == null) {
			throw new RecordNotFoundException("User not found in mysql database");
		} else {
		}
		return ResponseEntity.ok(users);
	}

	class RecordNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		RecordNotFoundException(String errorMessage) {
			super(errorMessage);
		}
	}

}