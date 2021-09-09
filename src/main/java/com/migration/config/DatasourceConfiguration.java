package com.migration.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DatasourceConfiguration {

	@Bean(name = "mysqlDatasource")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource mysqlDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresDatasource")
	@ConfigurationProperties(prefix = "postgresql.datasource")
	public DataSource postgresDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlJdbcTemplate")
	public NamedParameterJdbcTemplate mysqlJdbcTemplate(@Qualifier("mysqlDatasource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean(name = "postgresJdbcTemplate")
	public NamedParameterJdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDatasource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

}
