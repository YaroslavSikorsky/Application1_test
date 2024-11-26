package org.ysikorsky.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Sender {

	@Autowired
	public TaskManager taskManager;
	public SenderProcessor senderProcessor;
	public Receiver receiver;

	@Autowired
	public Sender(Receiver receiver, SenderProcessor senderProcessor) {
		this.receiver = receiver;
		this.senderProcessor = senderProcessor;

	}

	public int senderStart(int id) {
		senderProcessor.start();
		return taskManager.getSenderSpeed(id);
	}

	public int increaseSpeed(int id, int speed) {
		taskManager.increaseSpeed(id, speed);
		return taskManager.getSenderSpeed(id);
	}

	public int decreaseSpeed(int id, int speed) {
		taskManager.decreaseSpeed(id, speed);
		return taskManager.getSenderSpeed(id);
	}

	public int getSenderSpeed(int id) {
		return taskManager.getSenderSpeed(id);
	}

}


