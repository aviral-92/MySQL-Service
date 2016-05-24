package com.mySql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mySql.db.DbOperation;

@RestController
public class MySqlController {

	@Autowired
	private DbOperation dbOperation;

	@RequestMapping(value = "/createDatabase", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createDatabase() {
		dbOperation.createDb();
		String response = "Created database name 'aviraldb' 2 tables student and employee with fields - (id(Auto-increment),name,age) in both and 10 rows also.";
		System.out.println(response);

		return response;
	}

	@RequestMapping(value = "/getDataSource", method = RequestMethod.HEAD)
	public JdbcTemplate template() {
		return dbOperation.templateDB();
	}
}
