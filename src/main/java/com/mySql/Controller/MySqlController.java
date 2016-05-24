package com.mySql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mySql.db.DbOperation;

@RestController
public class MySqlController {

	@Autowired
	private DbOperation dbOperation;

	@RequestMapping(value = "/createDatabase")
	public void createDatabase() {
		dbOperation.createDb();
		System.out.println("Created database name 'aviraldb' 2 tables student and employee with ");
		System.out.println( "fields - (id(Auto-increment),name,age) in both and 10 rows also.");
	}
}
