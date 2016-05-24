package com.mySql.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mySql.db.DbOperation;

@Repository
public class DbOperationImpl implements DbOperation {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createDb() {

		List<String> args = null;
		int response = 0;

		String createSchema = "CREATE DATABASE if not exists aviraldb ;";

		String dropTable1 = "DROP TABLE IF EXISTS AviralDB.Student ;";

		String createTable1 = " CREATE TABLE if not exists aviraldb.Student( "
				+ "ID   INT NOT NULL AUTO_INCREMENT, "
				+ "NAME VARCHAR(20) NOT NULL, " + "AGE  INT NOT NULL, "
				+ "PRIMARY KEY (ID));";

		String insertStudent = "insert into aviraldb.Student (id, name, age) values (0, ?, ?)";

		String dropTable2 = "DROP TABLE IF EXISTS AviralDB.employee ;";

		String createTable2 = "CREATE TABLE if not exists aviraldb.employee( "
				+ "ID   INT NOT NULL AUTO_INCREMENT, "
				+ "NAME VARCHAR(20) NOT NULL, " + "AGE  INT NOT NULL, "
				+ "PRIMARY KEY (ID));";

		String insertEmployee = "insert into aviraldb.employee (id, name, age) values (0, ?, ?)";

		try {
			jdbcTemplate.execute(createSchema);
			jdbcTemplate.execute(dropTable1);
			jdbcTemplate.execute(dropTable2);
			jdbcTemplate.execute(createTable1);
			jdbcTemplate.execute(createTable2);

			for (int i = 1; i <= 10; i++) {
				args = new ArrayList<>();
				args.add("Aviral" + i);
				args.add("23");
				response = jdbcTemplate.update(insertStudent, args.toArray());
				response = jdbcTemplate.update(insertEmployee, args.toArray());
			}

			if (response > 0) {
				System.out.println("Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
