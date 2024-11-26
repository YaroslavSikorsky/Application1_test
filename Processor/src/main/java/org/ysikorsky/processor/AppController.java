package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
public class AppController {

	@Autowired
	AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}

	@PostMapping("/addTaskProcessor")
	public String addTaskProcessor() {
		return "Current starting processor name = " + appService.addTaskProcessor();
	}

	@GetMapping("/current-count-processor")
	public String getTaskProcessorCount() {
		return "Current processor count is " + appService.getTaskProcessorCount();
	}

	//____________________________ TASKS TABLE

	@PostMapping("/set-count-proc-def")
	public int setDefaultTaskProcessorCount(){
		return appService.setDefaultTaskProcessorCount();
	}

	//____________________________ PROCESSOR_SPEED TABLE

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

	@PostMapping("/set-processor-def")
	public int setDefaultProcessorSpeed(){
		return appService.setDefaultProcessorSpeed();
	}

	//____________________________ TESTS

	public void truncateProcessorSpeed() {
		appService.truncateProcessorSpeed();
	}

}
