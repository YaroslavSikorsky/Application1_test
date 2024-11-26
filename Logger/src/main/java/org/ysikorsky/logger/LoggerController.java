package org.ysikorsky.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;



@SpringBootApplication
@EnableJdbcRepositories(basePackages = {"org.ysikorsky.logger"})
public class LoggerController {

	public static void main(String[] args) {
		SpringApplication.run(LoggerController.class, args);
	}

}
