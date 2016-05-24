package com.mySql.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySqlController {

	@RequestMapping(value = "/createDatabase")
	public void createDatabase() {

		System.out.println("Hello");
	}
}
