package org.ysikorsky.controller.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.ysikorsky.processor.*;


import java.util.UUID;

@Configuration
@ComponentScan(basePackages = {"org.ysikorsky.controller", "org.ysikorsky.processor", "org.ysikorsky.storage"})
public class ApplicationConfig {


	@Bean
	public int provideSomeInteger() {
		NumbersGenerator numbersGenerator = new NumbersGenerator();
		return numbersGenerator.generateNumber();
	}

	@Bean
	public String provideSomeString() {
		return UUID.randomUUID().toString();
	}

	@Bean
	public ServiceMVC provideSomeService(){
		return new ServiceMVC();
	}


}