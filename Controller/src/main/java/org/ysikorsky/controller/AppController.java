package org.ysikorsky.controller;

import org.mockito.internal.creation.settings.CreationSettings;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AppController {

	@Autowired
	AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}

	//***************************** SENDER

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

	//***************************** PROCESSOR

	@PostMapping("/addTaskProcessor")
	public String addTaskProcessor() {
		return "Current starting processor name = " + appService.addTaskProcessor();
	}

	@GetMapping("/current-count-processor")
	public String getTaskProcessorCount() {
		return "Current processor count is " + appService.getTaskProcessorCount();
	}

	@PostMapping("/increase-speed-processor")
	public int increaseSpeedProcessor(@RequestBody int body) {
		return appService.increaseSpeedProcessor(body);
	}

	@PostMapping("/decrease-speed-processor")
	public int decreaseSpeedProcessor(@RequestBody int body) {
		return appService.decreaseSpeedProcessor(body);
	}

	@GetMapping("/current-speed-processor")
	public String currentSpeedProcessor() {
		return "Current speed is " + appService.currentSpeedProcessor();
	}

	//***************************** TEST

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
