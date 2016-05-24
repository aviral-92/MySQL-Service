package com.mySql.db;

import org.springframework.jdbc.core.JdbcTemplate;

public interface DbOperation {

	public void createDb();
	
	public JdbcTemplate templateDB();
}
