package com.migration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;

import com.migration.models.User;

@Service
public class PostgresDataService {

	@Autowired
	@Qualifier("postgresJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	public int[] batchUpdate(List<User> aqs) {
		final String query = "insert into public.User(username, lastname) " + " values (:username, :lastname)";
		SqlParameterSource[] parameters = SqlParameterSourceUtils.createBatch(aqs.toArray());
		int[] updateCounts = jdbcTemplate.batchUpdate(query, parameters);
		return updateCounts;
	}
}
