package org.ysikorsky.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ysikorsky.storage.StorageTask;

import java.util.List;

@RestController
public class ControllerMVC {

	@Autowired
	ServiceMVC serviceMVC;

	@GetMapping("/home")
	public String home() {
		return serviceMVC.home();
	}

	@PutMapping("/add")
	public List<String> createTask() {
		return serviceMVC.createTask();
	}

	@GetMapping("/aco")
	public HttpStatus accomplishTask() {
		return serviceMVC.accomplishTask();
	}

	@GetMapping("/all")
	public List<StorageTask> viewTasks() {
		return serviceMVC.viewTasks();
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<StorageTask>> getTasks() {
		return serviceMVC.getTasks();
	}

}
