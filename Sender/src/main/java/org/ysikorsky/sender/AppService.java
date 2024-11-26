package org.ysikorsky.sender;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class AppService {

	@Autowired
	private Sender sender;

	@Autowired
	private TaskService taskService;

	//____________________________ TASKS TABLE

	public int senderStart() {

		truncateSenderSpeed();
		setDefaultSenderSpeed();
		sender.senderStart(1);
		return taskService.getSenderSpeed(1);
	}

	//____________________________ SENDERS TABLE

	public int increaseSpeed(int speed) {
		return sender.increaseSpeed(1, speed);
	}

	public int decreaseSpeed(int speed) {
		return sender.decreaseSpeed(1, speed);
	}

	public int currentSpeed() {
		return sender.getSenderSpeed(1);
	}

	public int setDefaultSenderSpeed(){
		return taskService.setSenderSpeed(1, 1);
	}

	public void truncateSenderSpeed(){
		taskService.truncateSenderSpeed();
	}
}
