package org.ysikorsky.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;



@SpringBootApplication
@EnableJdbcRepositories(basePackages = {"org.ysikorsky.sender"})
public class SenderController {

	public static void main(String[] args) {
		SpringApplication.run(SenderController.class, args);
	}

}
