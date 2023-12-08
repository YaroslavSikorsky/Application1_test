package org.ysikorsky.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ysikorsky.processor.Sender;
import org.ysikorsky.processor.TaskProcessor;

import org.ysikorsky.storage.StorageTask;
import org.ysikorsky.storage.TaskStorage;

import java.util.ArrayList;
import java.util.List;


@Service
public class ServiceMVC {

	@Autowired
	private Sender sender;

	@Autowired
	private TaskProcessor taskProcessor;

//	@Autowired
//	private TaskProcessor taskProcessor2;

	@Autowired
	private TaskStorage taskStorage;

	public String home() {
		return "home";
	}

	public List<String> createTask() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			list.add(sender.sendRequestTask());
		}
		return list;
	}

	public HttpStatus accomplishTask() {
		taskProcessor.start();
//		taskProcessor2.start(); //Попытка многопоточность запустить, вылетает ошибка
		return HttpStatus.ACCEPTED;
	}

	public List<StorageTask> viewTasks() {
		return taskStorage.allTasks();
	}

	public ResponseEntity<List<StorageTask>> getTasks() {
		List<StorageTask> tasks = taskStorage.allTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
}
