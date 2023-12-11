package org.ysikorsky.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ysikorsky.storage.StorageTask;

import java.util.List;

// TODO поменять название (мб спид контроллер)
@RestController
public class AppController {

	@Autowired
	AppService appService;

	// TODO один для включения SenderProcessor
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

	@GetMapping("/tasksList")
	public List<StorageTask> getTasks() {
		return appService.getTasks();
	}

}
