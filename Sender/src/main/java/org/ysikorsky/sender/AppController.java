package org.ysikorsky.sender;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
public class AppController {

	@Autowired
	AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}

	//____________________________ TASKS TABLE

	@PostMapping("/senderStart")
	public String senderStart() {
		return "Sender speed is " + appService.senderStart();
	}

	//____________________________ SENDERS TABLE

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

	@GetMapping("/set-sender-def")
	public int setDefaultSenderSpeed(){
		return appService.setDefaultSenderSpeed();
	}


}
