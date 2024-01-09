package org.ysikorsky.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


//*************1 для переноса в сторедж
import org.ysikorsky.storage.StorageTask;


@RestController
public class AppController {

	@Autowired
	AppService appService;

	@PostMapping("/senderStart")
	public String senderStart() {
		return "Sender speed is " + appService.senderStart();
	}

	// TODO increase-decrease add
	@PostMapping("/increase-speed")
	public int increaseSpeed(@RequestBody int body) {
		return appService.increaseSpeed(body);
	}

	@PostMapping("/decrease-speed")
	public int decreaseSpeed(@RequestBody int body) {
		return appService.decreaseSpeed(body);
	}

	@GetMapping("/current-speed")
	public String currentSpeed() {
		return "Current speed is " + appService.currentSpeed();
	}

	// TODO добавить чтобы можно было устанавливать количество потоков
	@PostMapping("/addTaskProcessor")
	public String addTaskProcessor() {
		return appService.addTaskProcessor();
	}

	//*****************************

	@GetMapping("/tasksList")
	public @ResponseBody
	Iterable<StorageTask> getAllTasks() {
		return appService.getAllTasks();
	}

	@PostMapping("/add")
	public @ResponseBody
	ResponseEntity<StorageTask> createTask(@RequestBody StorageTask task) {
		StorageTask storageTask = appService.createTask(task);
		return new ResponseEntity<>(storageTask, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public @ResponseBody
	Optional<StorageTask> getTask(@PathVariable String id) {
		return appService.getTask(id);
	}


}
