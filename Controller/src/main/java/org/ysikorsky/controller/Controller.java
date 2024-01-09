package org.ysikorsky.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;


//*************1 для переноса в сторедж
@SpringBootApplication
@EnableJdbcRepositories(basePackages = {"org.ysikorsky.storage"})
@ComponentScan(basePackages = {"org.ysikorsky.processor", "org.ysikorsky.storage"})
public class Controller {

	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
	}

}
