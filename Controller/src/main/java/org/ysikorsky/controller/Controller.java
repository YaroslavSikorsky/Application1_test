package org.ysikorsky.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.ysikorsky.controller.controllers.AppConfig;



@SpringBootApplication
@ComponentScan(basePackages = {"org.ysikorsky.processor"})
@ComponentScan(basePackages = {"org.ysikorsky.storage"})
@Import(AppConfig.class)
public class Controller {

	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
	}

}
