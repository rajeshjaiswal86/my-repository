package com.migration.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.migration.models.User;

@Service
public class MysqlDataService {

	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<User> listUsers() {
		final String query = "SELECT    `User_`.`firstName` as firstName,\n" + "    `User_`.`lastName` as lastName,\n"
				+ "FROM ``User_`;\n";

		Map<String, Object> parameters = new HashMap<>();
		return jdbcTemplate.query(query, parameters,
				(rs, rowNum) -> new User(rs.getString("firstName"), rs.getString("lastName")));
	}
}
