package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Sender {
	// TODO мб сделать чтобы сендер тоже сразу стартовал свой поток, чтобы мусор убрать из контроллера
	public SenderProcessor senderProcessor;
	public int senderSpeed = 10;
	public Receiver receiver;


	@Autowired
	public Sender(Receiver receiver, TaskService taskService) {
		this.receiver = receiver;
		this.senderProcessor = new SenderProcessor(senderSpeed, receiver);

	}

	public int getSenderSpeed() {
		return senderSpeed;
	}

	public int increaseSpeed(int speed) {
		senderSpeed += speed;
		senderProcessor.setSenderSpeed(senderSpeed);
		return senderSpeed;
	}

	public int decreaseSpeed(int speed) {
		senderSpeed -= speed;
		senderProcessor.setSenderSpeed(senderSpeed);
		return senderSpeed;
	}

	public int senderStart() {
		senderProcessor.start();
		return senderProcessor.getSenderSpeed();
	}


}


