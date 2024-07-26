package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Sender {

	@Autowired
	public TaskStorage taskStorage;
	public SenderProcessor senderProcessor;
	public Receiver receiver;

	@Autowired
	public Sender(Receiver receiver, SenderProcessor senderProcessor) {
		this.receiver = receiver;
		this.senderProcessor = senderProcessor;

	}

	public int senderStart(int id) {
		senderProcessor.start();
		return taskStorage.getSenderSpeed(id);
	}

	public int increaseSpeed(int id, int speed) {
		taskStorage.increaseSpeed(id, taskStorage.getSenderSpeed(id) + speed);
		return taskStorage.getSenderSpeed(id);
	}

	public int decreaseSpeed(int id, int speed) {
		taskStorage.decreaseSpeed(id, taskStorage.getSenderSpeed(id) - speed);
		return taskStorage.getSenderSpeed(id);
	}

	public int getSenderSpeed(int id) {
		return taskStorage.getSenderSpeed(id);
	}

}


