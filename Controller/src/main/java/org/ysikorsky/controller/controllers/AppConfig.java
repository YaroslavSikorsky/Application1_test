package org.ysikorsky.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.ysikorsky.processor.LoggerThread;
import org.ysikorsky.processor.TaskProcessor;
import org.ysikorsky.processor.TaskService;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class AppConfig {

	// бин создастся 1 раз при создании при старте контекста
	@Bean
	public List<TaskProcessor> provideSomeTaskProcessor(@Autowired TaskService taskService) {
		List<TaskProcessor> taskProcessorList = new ArrayList<>();
		taskProcessorList.add(new TaskProcessor(taskService));
		taskProcessorList.add(new TaskProcessor(taskService));
		taskProcessorList.add(new TaskProcessor(taskService));
		System.out.println("taskProcessorList: " + taskProcessorList.toString());
		return taskProcessorList;
	}

	@Bean
	public LoggerThread provideSomeLoggerThread(@Autowired TaskService taskService) {
		LoggerThread loggerThread = new LoggerThread(taskService);
		System.out.println("loggerThread state: " + loggerThread.getState() + ", loggerThread name: " + loggerThread.getName());
		return loggerThread;
	}


}
