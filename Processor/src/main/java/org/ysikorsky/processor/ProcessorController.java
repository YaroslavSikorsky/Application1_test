package org.ysikorsky.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;



@SpringBootApplication
@EnableJdbcRepositories(basePackages = {"org.ysikorsky.processor"})
public class ProcessorController {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorController.class, args);
	}

}
